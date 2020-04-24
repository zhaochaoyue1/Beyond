package com.example.rocketmq.schedulemessage;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

public class ScheduleMessageProducer {
    public static void main(String[] args) throws Exception{
        //创建消息生产者
        DefaultMQProducer producer = new DefaultMQProducer("schedule_message_example");
        //指定地址
        producer.setNamesrvAddr("localhost:9876");
        producer.start();
        for (int i=0;i<10;i++){
            Message msg = new Message("TestTopicScheduled",("hello scheduled message " + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            //设置延时级别
            msg.setDelayTimeLevel(3);
            producer.send(msg);
        }
        producer.shutdown();
    }
}
