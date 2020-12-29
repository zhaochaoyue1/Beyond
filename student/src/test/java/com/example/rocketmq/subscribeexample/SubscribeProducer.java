package com.example.rocketmq.subscribeexample;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.util.List;

public class SubscribeProducer {
    public static void main(String[] args) throws Exception {
        //创建一个生产者组
        DefaultMQProducer producer = new DefaultMQProducer("example_group_name");
        //设置链接地址
        producer.setNamesrvAddr("localhost:9876");
        //启动生产者
        producer.start();
        //创建一个tag数组
        String[] tags = new String[]{"TagA"};
        for (int i = 0; i < 1; i++) {
            int orderId = i%10;
            Message msg = new Message("TopicTestjjj",tags[i%tags.length],"KEY"+i,("Hello Rocket" + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult sendResult = producer.send(msg, new MessageQueueSelector() {
                @Override
                public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
                    Integer id = (Integer) arg;
                    int index = id % mqs.size();
                    return mqs.get(index);
                }
            },orderId);
            System.out.printf("%s%n",sendResult);
        }
        producer.shutdown();
    }
}
