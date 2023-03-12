package com.example.thread.ccountDownLatch;

import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @description: CountDownLatchBoss
 * @date: 2021/11/29 上午11:49
 * @author: zcy
 * @version: 1.0
 */
public class CountDownLatchBoss {
    private static ExecutorService executors = Executors.newCachedThreadPool();
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch count = new CountDownLatch(3);
        Boss boss = new Boss(count, "老板");
        Worker worker1 = new Worker(count, "员工1");
        Worker worker2 = new Worker(count, "员工2");
        Worker worker3 = new Worker(count, "员工3");

        executors.execute(worker1);
        executors.execute(worker2);
        executors.execute(worker3);
        executors.execute(boss);
        count.await();
        System.out.println("主线程执行结束");
        executors.shutdown();
    }
}
class Boss implements Runnable {
    private CountDownLatch countDownLatch;
    private String name;

    @SneakyThrows
    @Override
    public void run() {
        countDownLatch.await();
        System.out.println(name + "检查完了");
    }

    public Boss(CountDownLatch countDownLatch, String name) {
        this.countDownLatch = countDownLatch;
        this.name = name;
    }
}
class Worker implements Runnable{
    private CountDownLatch countDownLatch;
    private String name;

    @SneakyThrows
    @Override
    public void run() {
        System.out.println(name + "执行完");
        TimeUnit.SECONDS.sleep(5);

        countDownLatch.countDown();
    }

    public Worker(CountDownLatch countDownLatch, String name) {
        this.countDownLatch = countDownLatch;
        this.name = name;
    }
}
