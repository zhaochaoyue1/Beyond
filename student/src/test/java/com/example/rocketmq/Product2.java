package com.example.rocketmq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.*;
import org.apache.rocketmq.common.CountDownLatch2;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: Product2
 * @date: 2020/12/22 下午7:42
 * @author: zcy
 * @version: 1.0
 */
public class Product2 {
   /* public static final String GROUP = "please_rename_unique_group_name";
    public static final String TOPIC = "TopicTest007";
    public static final String ADDR = "localhost:9876";
    public static void main(String[] args) throws MQClientException {
        DefaultMQProducer producer = new DefaultMQProducer(GROUP);
        producer.setNamesrvAddr(ADDR);
        producer.start();
        productOperation(producer);
    }

    public static void productOperation(DefaultMQProducer producer){
        try {
            Message message = new Message(TOPIC, "1234".getBytes(StandardCharsets.UTF_8));
            producer.send(message);
        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (MQBrokerException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        producer.shutdown();
    }*/

    public static final String GROUP = "GROUP_ONE";
    public static final String ADDR = "localhost:9876";
    public static final String TOPIC = "TOPIC_ONE";
    public static final String TAG = "A";

    public static void main(String[] args) throws MQClientException {
        DefaultMQProducer producer = new DefaultMQProducer(GROUP);
        producer.setNamesrvAddr(ADDR);
        Message message = new Message(TOPIC, TAG, "hello world".getBytes());
        producer.start();
        try {
            producer.send(message);
        } catch (MQClientException | RemotingException | MQBrokerException | InterruptedException e) {
            e.printStackTrace();
        }
        producer.shutdown();
        /*try {
            Message message2 = new Message(TOPIC, "hello world2".getBytes());
            producer.send(message2);
        } catch (MQClientException | RemotingException | MQBrokerException | InterruptedException e) {
            e.printStackTrace();
        }*/
    }
}

//异步发送消息
class AsyncProduct {
    public static void main(String[] args) throws MQClientException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer(Consumer2.GROUP);
        producer.setNamesrvAddr(Consumer2.ADDR);
        producer.start();
        producer.setRetryTimesWhenSendAsyncFailed(0);
        int messageCount = 100;
        CountDownLatch2 countDownLatch2 = new CountDownLatch2(messageCount);
        for (int i = 0; i < messageCount; i++) {
            final int index = 1;
            Message message = new Message(Consumer2.TOPIC, Consumer2.TAG, ("asyncProduct test " + i).getBytes(StandardCharsets.UTF_8));
            try {
                producer.send(message, new SendCallback() {
                    @Override
                    public void onSuccess(SendResult sendResult) {
                        System.out.printf("%-10d OK %s %n", index, sendResult.getMsgId());
                    }

                    @Override
                    public void onException(Throwable e) {
                        System.out.printf("%-10d Exception %s %n", index, e);
                        e.printStackTrace();
                    }
                });
            } catch (RemotingException | InterruptedException e) {
                e.printStackTrace();
            }
        }
        //等待5秒
        countDownLatch2.await(10, TimeUnit.SECONDS);
        producer.shutdown();
    }
}

//单向发送消息
class OneProducer {
    public static void main(String[] args) throws MQClientException {
        DefaultMQProducer producer = new DefaultMQProducer(Product2.GROUP);
        producer.setNamesrvAddr(Product2.ADDR);
        producer.start();
        for (int i = 0; i < 20; i++) {
            Message message = new Message(Product2.TOPIC, Product2.TAG, "one way ".getBytes());
            try {
                producer.sendOneway(message);
            } catch (RemotingException | InterruptedException e) {
                e.printStackTrace();
            }
        }
        producer.shutdown();

    }
}

//顺序发送
class OrderProduct {
    public final static String GROUP = "ORDER_TEST";
    public final static String TOPIC = "ORDER_TEST_TOPIC";
    public static void main(String[] args) throws MQClientException {
        DefaultMQProducer producer = new DefaultMQProducer(GROUP);
        producer.setNamesrvAddr(Product2.ADDR);
        producer.start();
        String[] tags = new String[]{"A1","A2","A3"};
        List<OrderStep> orderList = new OrderProduct().buildOrder();
        String dateStr = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-mm-dd HH:mm:ss"));
        for (int i = 0; i < 10; i++) {
            String body = dateStr + " hello RocketMq " + orderList.get(i);
            Message msg = new Message(TOPIC, tags[i % tags.length], "KEY" + i, body.getBytes());
            try {
                SendResult send = producer.send(msg, (mqs, message, arg) -> {
                    Long id = (Long) arg;//根据订单ID选择发送queue
                    long index = id % mqs.size();
                    return mqs.get((int) index);
                }, orderList.get(i).orderId);
                System.out.println(String.format("SendResult status:%s, queue:%d, body:%s",
                        send.getSendStatus(),
                        send.getMessageQueue().getQueueId(),
                        body));
            } catch (RemotingException | MQBrokerException | InterruptedException e) {
                e.printStackTrace();
            }
        }
        producer.shutdown();
    }

    private static class OrderStep {
        private long orderId;
        private String desc;

        public long getOrderId() {
            return orderId;
        }

        public void setOrderId(long orderId) {
            this.orderId = orderId;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        @Override
        public String toString() {
            return "OrderStep{" +
                    "orderId=" + orderId +
                    ", desc='" + desc + '\'' +
                    '}';
        }

        public OrderStep(long orderId, String desc) {
            this.orderId = orderId;
            this.desc = desc;
        }
    }

    private List<OrderStep> buildOrder() {
        List<OrderStep> orderList = new ArrayList<>();
        orderList.add(new OrderStep(15103111039L, "创建"));
        orderList.add(new OrderStep(15103111065L, "创建"));
        orderList.add(new OrderStep(15103111039L, "付款"));
        orderList.add(new OrderStep(15103117235L, "创建"));
        orderList.add(new OrderStep(15103111065L, "付款"));
        orderList.add(new OrderStep(15103117235L, "付款"));
        orderList.add(new OrderStep(15103111065L, "完成"));
        orderList.add(new OrderStep(15103111039L, "推送"));
        orderList.add(new OrderStep(15103117235L, "完成"));
        orderList.add(new OrderStep(15103111039L, "完成"));
        return orderList;
    }

}

//发送延时消息
class ScheduledProduct{
    public static final String GROUP = "SCHEDULED_MESSAGE_GROUP";
    public static final String TOPIC = "SCHEDULED_MESSAGE_TOPIC";

    public static void main(String[] args) throws MQClientException {
        DefaultMQProducer producer = new DefaultMQProducer(GROUP);
        producer.setNamesrvAddr(Product2.ADDR);
        producer.start();
        for (int i = 0; i < 20; i++) {
            Message message = new Message(TOPIC, "scheduled MQ".getBytes(StandardCharsets.UTF_8));
            //设置延时等级3，这个消息将在10s之后发送（现在支持固定的几个时间，详看delayTimeLevel）,延迟对应的时间存储到broker
            //messageDelayLevel = "1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h";
            //
            message.setDelayTimeLevel(3);
            try {
                producer.send(message);
                System.out.println(System.currentTimeMillis());
            } catch (RemotingException | MQBrokerException | InterruptedException e) {
                e.printStackTrace();
            }
        }
        producer.shutdown();
    }
}

class TransactionProduct {
    public static final String GROUP = "TRANSACTION_MESSAGE_GROUP";
    public static final String TOPIC = "TRANSACTION_MESSAGE_GROUP";

    public static void main(String[] args) throws MQClientException, InterruptedException {
        TransactionMQProducer producer = new TransactionMQProducer(GROUP);
        producer.setNamesrvAddr(Product2.ADDR);
        //引入rocketmq-client和rockemq-common包
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(2, 5,
                100, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(2000),
                r -> {
                    Thread thread = new Thread(r);
                    thread.setName("client-transaction-msg-check-thread");
                    return thread;
                });
        producer.setExecutorService(executorService);
        producer.setTransactionListener(new TransactionListenerImpl());
        producer.start();
        String[] tags = {"TagA", "TagB", "TagC", "TagD", "TagE"};
        for (int i = 0; i < 10; i++) {
            Message message = new Message(TOPIC, tags[i % tags.length], "KEY" + i, ("hello RocketMq" + i).getBytes(StandardCharsets.UTF_8));
            TransactionSendResult transactionSendResult = producer.sendMessageInTransaction(message, null);
            System.out.printf("%s%n",transactionSendResult);
            Thread.sleep(10);
        }
        for (int i = 0; i < 20; i++) {
            Thread.sleep(1000);
        }
        producer.shutdown();
    }
}
class TransactionListenerImpl implements TransactionListener{
    private AtomicInteger transactionIndex = new AtomicInteger(0);
    private ConcurrentHashMap<String,Integer> localTrans = new ConcurrentHashMap<>();
    @Override
    public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {
        int value = transactionIndex.getAndIncrement();
        int status = value % 3;
        localTrans.put(msg.getTransactionId(),status);
        return LocalTransactionState.UNKNOW;
    }

    @Override
    public LocalTransactionState checkLocalTransaction(MessageExt msg) {
        Integer status = localTrans.get(msg.getTransactionId());
        if(null!=status){
            switch (status){
                case 0:
                    return LocalTransactionState.UNKNOW;
                case 1:
                    return LocalTransactionState.COMMIT_MESSAGE;
                case 2:
                    return LocalTransactionState.ROLLBACK_MESSAGE;
            }
        }
        return LocalTransactionState.COMMIT_MESSAGE;
    }
}



