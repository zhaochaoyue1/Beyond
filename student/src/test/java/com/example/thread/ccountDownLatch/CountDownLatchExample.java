package com.example.thread.ccountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @description: CountDownLatchExample
 * @date: 2020/9/10 下午3:37
 * @author: zcy
 * @version: 1.0
 */
public class CountDownLatchExample {
    public static void main(String[] args) throws Exception {
        CountDownLatch latch = new CountDownLatch(5);
        Service service = new Service(latch);
        Runnable task = service::exec;
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(task);
            thread.start();
        }
        System.out.println("main thread await. ");
        latch.await();
        System.out.println("main thread finishes await. ");
    }
}

class Service {
    private CountDownLatch latch;

    public Service(CountDownLatch countDownLatch) {
        this.latch = countDownLatch;
    }

    public void exec() {
        try {
            System.out.println(Thread.currentThread().getName() + " execute task. ");
            sleep(5);
            System.out.println(Thread.currentThread().getName() + " finished task ");
        } finally {
            latch.countDown();
        }
    }

    public void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep((seconds));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
