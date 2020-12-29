package com.example.rocketmq;

import com.example.student.util.RandomUtil;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.*;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.*;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;
import org.aspectj.weaver.ast.Or;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: Consumer2
 * @date: 2020/12/22 下午6:15
 * @author: zcy
 * @version: 1.0
 */
public class Consumer2 {
    /*public static final String GROUP = "please_rename_unique_group_name";
    public static final String ADDR = "localhost:9876";
    public static final String TOPIC = "TopicTest007";
    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(GROUP);
        consumer.setNamesrvAddr(ADDR);
        consumer.setMessageModel(MessageModel.CLUSTERING);
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        consumer.subscribe(TOPIC,"*");
        consumer.registerMessageListener((MessageListenerOrderly) (msgs, context)->{
            context.setAutoCommit(true);
            try {
                for(MessageExt msg:msgs){
                    String s = new String(msg.getBody(), StandardCharsets.UTF_8);
                    System.out.println(s);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return ConsumeOrderlyStatus.SUCCESS;
        });
        consumer.start();
        System.out.println("consumer start success");
    }*/

    public static final String GROUP = "GROUP_ONE";
    public static final String TOPIC = "TOPIC_ONE";
    public static final String TAG = "*";
    public static final String ADDR = "localhost:9876";

    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(GROUP);
        consumer.setNamesrvAddr(ADDR);
        consumer.subscribe(TOPIC, TAG);
        consumer.registerMessageListener((MessageListenerOrderly) (messageExts, context) -> {
            context.setAutoCommit(true);
            try {
                for (MessageExt messageExt : messageExts) {
                    String s = new String(messageExt.getBody(), StandardCharsets.UTF_8);
                    System.out.println(s);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return ConsumeOrderlyStatus.SUCCESS;
        });
        consumer.start();
        System.out.println("consumer start");
    }
}

//顺序消息消费，带事物方式（应用可以控制offSet在什么时候可以提交）
class OrderConsumer {
    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(OrderProduct.GROUP);
        consumer.setNamesrvAddr(Consumer2.ADDR);
        consumer.subscribe(OrderProduct.TOPIC, Consumer2.TAG);
        try {
            consumer.registerMessageListener((MessageListenerOrderly) (msgs, context) -> {
                context.setAutoCommit(true);
                Random random = new Random();
                for (MessageExt msg : msgs) {
                    System.out.println("consumerThread=" + Thread.currentThread().getName()
                            + " queueId=" + msg.getQueueId()
                            + " content:" + new String(msg.getBody(), StandardCharsets.UTF_8));
                }
                try {
                    TimeUnit.SECONDS.sleep(random.nextInt(10));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return ConsumeOrderlyStatus.SUCCESS;
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        consumer.start();
        System.out.println("consumer success");
    }
}

//延时消息消费
class ScheduledConsumer {
    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(ScheduledProduct.GROUP);
        consumer.setNamesrvAddr(Product2.ADDR);
        consumer.subscribe(ScheduledProduct.TOPIC, "*");
        consumer.registerMessageListener((MessageListenerConcurrently) (msgs, context) -> {
            for (MessageExt msg : msgs) {
                System.out.println("receive message[msgId=" + msg.getMsgId() + "]" + (System.currentTimeMillis() - msg.getStoreTimestamp()) + "ms later" + "storeTimestamp=" + msg.getStoreTimestamp());
            }
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });
        consumer.start();
        System.out.println("consumer start");
    }
}

class TransactionConsumer {
    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(TransactionProduct.GROUP);
        consumer.setNamesrvAddr(Product2.ADDR);
        consumer.subscribe(TransactionProduct.TOPIC, "*");
        consumer.registerMessageListener((MessageListenerOrderly) (messageExts, context) -> {
            context.setAutoCommit(true);
            for (MessageExt messageExt : messageExts) {
                String s = new String(messageExt.getBody(), StandardCharsets.UTF_8);
                System.out.println(s);
            }
            return ConsumeOrderlyStatus.SUCCESS;
        });
        consumer.start();
        System.out.println("transaction consumer start.");
    }
}
