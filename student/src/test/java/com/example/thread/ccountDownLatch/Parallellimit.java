package com.example.thread.ccountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: Parallellimit
 * @date: 2020/9/7 下午9:53
 * @author: zcy
 * @version: 1.0
 */
public class Parallellimit {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newCachedThreadPool();
        CountDownLatch cdl = new CountDownLatch(10);
        for(int i=0;i<10;i++){
            CountRunnable runnable = new CountRunnable(cdl);

            pool.execute(runnable);
        }
        cdl.await();
        pool.shutdown();
    }
}

class CountRunnable implements Runnable{
    private static AtomicInteger i = new AtomicInteger(0);
    private CountDownLatch countDownLatch;
    public CountRunnable(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        thread.setName(i.incrementAndGet() +"");
        try {
            synchronized(countDownLatch){
                //每次减少一个容量
                countDownLatch.countDown();
                System.out.println(thread.getName() + "thread counts = " + (countDownLatch.getCount()));
                Thread.sleep(1000);
            }
            countDownLatch.await();
            System.out.println(thread.getName() + " concurrency counts = " + (10 -countDownLatch.getCount()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}