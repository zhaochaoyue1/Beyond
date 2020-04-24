package com.example.rocketmq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

public class OneWayProducer {
    public static void main(String[] args) throws Exception {
        //创建提供者实例
        DefaultMQProducer producer = new DefaultMQProducer("please_rename_unique_group_name");
        //指定服务地址
        producer.setNamesrvAddr("localhost:9876");
        //启动实例
        producer.start();
        //循环发送消息
        for (int i = 0; i < 10; i++) {
            Message msg = new Message("TopicTest","TagA",(" hello RocketMQ"+i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            producer.sendOneway(msg);
        }
        //关闭消息提供者
        producer.shutdown();
    }
}
