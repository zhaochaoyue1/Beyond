package com.example.thread.time;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.tools.ant.taskdefs.Sleep;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @description: Timer
 * @date: 2023/8/23 下午4:58
 * @author: zcy
 * @version: 1.0
 */
public class Timer {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        DelayQueue<DelayedUser> delayeds = new DelayQueue<>();
        int messageCount= 2;
        long delayTime = 500;
        DelayedQueueProducer delayedQueueProducer = new DelayedQueueProducer(delayeds, messageCount, delayTime);
        DelayedQueueConsumer delayedQueueConsumer = new DelayedQueueConsumer(delayeds, messageCount);

        pool.submit(delayedQueueProducer);
        pool.submit(delayedQueueConsumer);

        pool.awaitTermination(5,TimeUnit.SECONDS);
        pool.shutdown();

    }
}

@Data
@NoArgsConstructor
class DelayedUser implements Delayed{
    private String name;
    private long avaibleTime;
    @Override
    public long getDelay(TimeUnit unit) {
        //判断avaibleTime是否大于当前系统时间，并将结果转换成MILLISECONDS
        long diffTime = avaibleTime - System.currentTimeMillis();
        return unit.convert(diffTime,TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        //compareTo 用在DelayedUser的排序
        return (int)(this.avaibleTime - ((DelayedUser)o).getAvaibleTime());
    }

    public DelayedUser(String name, long delayTime){
        this.name=name;
        //avaibleTime = 当前时间+ delayTime
        this.avaibleTime=delayTime + System.currentTimeMillis();

    }
}

@Slf4j
@Data
@AllArgsConstructor
class DelayedQueueProducer implements  Runnable{
    private  DelayQueue<DelayedUser> delayedUsers;
    private Integer messageCount;
    private long delayedTime;
    @Override
    public void run() {
        try {
            for (int i = 0; i < messageCount; i++) {
                DelayedUser delayedUser = new DelayedUser(new Random().nextInt(1000)+"", delayedTime);
                log.info("put delayedUser {}",delayedUser);
                delayedUsers.put(delayedUser);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

@Slf4j
@Data
@AllArgsConstructor
class DelayedQueueConsumer implements Runnable {

    private DelayQueue<DelayedUser> delayQueue;

    private int messageCount;

    @SneakyThrows
    @Override
    public void run() {

        for (int i = 0; i < messageCount; i++) {
            while (true){
                DelayedUser poll = delayQueue.take();

                log.info("take {}",poll );

            }
        }
    }
}

