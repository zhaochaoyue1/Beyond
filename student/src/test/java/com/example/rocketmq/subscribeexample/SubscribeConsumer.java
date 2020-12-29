package com.example.rocketmq.subscribeexample;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class SubscribeConsumer {
    public static void main(String[] args) throws Exception {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("example_group_name");
        consumer.setNamesrvAddr("localhost:9876");
        consumer.subscribe("TopicTestjjj", "TagA");
        consumer.setMessageModel(MessageModel.CLUSTERING);
        consumer.registerMessageListener(new MessageListenerOrderly() {
            AtomicLong consumeTime = new AtomicLong(0);

            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs, ConsumeOrderlyContext context) {
                context.setAutoCommit(true);
                //System.out.printf(Thread.currentThread().getName() + "receive new message" + msgs + "%n");
                try {
                    for(MessageExt messageExt:msgs){
                        String msg = new String(messageExt.getBody(),"utf-8");
                        System.out.println(msg);
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                this.consumeTime.incrementAndGet();
                if ((this.consumeTime.get() % 2 == 0)) {
                    return ConsumeOrderlyStatus.SUCCESS;
                } else if ((this.consumeTime.get() % 3) == 0) {
                    return ConsumeOrderlyStatus.ROLLBACK;
                } else if ((this.consumeTime.get() % 5) == 0) {
                    context.setSuspendCurrentQueueTimeMillis(3000);
                    return ConsumeOrderlyStatus.SUSPEND_CURRENT_QUEUE_A_MOMENT;
                }
                return ConsumeOrderlyStatus.SUCCESS;
            }
        });
        consumer.start();
        System.out.printf("Consumer Start.%n");
    }
}
