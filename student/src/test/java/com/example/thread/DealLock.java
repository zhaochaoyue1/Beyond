package com.example.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @description: DealLock
 * @date: 2021/2/5 下午9:09
 * @author: zcy
 * @version: 1.0
 */
public class DealLock {

    static Integer value = 0;

    //线程1执行此方法
    public synchronized void thisLock() throws InterruptedException {
        value++;
        System.out.println(value);
        TimeUnit.SECONDS.sleep(600);
    }

    public static synchronized void lockClass() {
        value++;
        System.out.println(value);
    }

    public static void add() {
        value++;
    }

    public static void main(String[] args) throws Exception {
        Object objectA = new Object();
        Object objectB = new Object();
        new Thread(() -> {
            String name = Thread.currentThread().getName();
            synchronized (objectA) {
                System.out.println(name + " : 获得objectA");
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (objectB) {
                    System.out.println(name + ": 获得objectB");
                    objectB.notifyAll();
                }
            }
        }, "线程A").start();
        new Thread(() -> {
            String name = Thread.currentThread().getName();
            synchronized (objectB) {
                System.out.println(name + " : 获得objectB");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                long currentTimeMillis = System.currentTimeMillis();
                while (true) {
                    long currentTimeMillis1 = System.currentTimeMillis();
                    if ((currentTimeMillis1 - currentTimeMillis) / 1000 > 3) {
                        break;
                    }
                }
                try {
                    objectB.wait();
                    System.out.println("等待结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (objectA) {
                    System.out.println(name + ": 获得objectA");
                }
            }

        }, "线程B").start();
        Thread.sleep(20000);
    }
}

class X {
    public static void main(String[] args) throws InterruptedException {
        new Thread(DealLock::lockClass, "线程1").start();
        TimeUnit.SECONDS.sleep(1);
        DealLock.add();
        System.out.println(DealLock.value);
    }
}

class Wait {
    public static void main(String[] args) {
        Object o = new Object();
        new Thread(() -> {
            System.out.println("图片开始下载");
            for (int i = 0; i < 11; i++) {
                System.out.println("图片下载：" + i * 10 + "%");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("图片下载完成");
            synchronized (o) {
                o.notify();
            }
            System.out.println("附件开始下载");
            for (int i = 0; i < 11; i++) {
                System.out.println("附件下载：" + i * 10 + "%");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("附件结束下载");
        }).start();
        new Thread(() -> {
            synchronized (o) {
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("准备展示图片");
                System.out.println("图片展示");
            }
        }).start();
    }
}


/**
 * 线程池训练
 * https://www.cnblogs.com/exe19/p/5359885.html
 */

class ThreadPoolPractice {
    public static void main(String[] args)throws Exception {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(5,
                10,
                1000,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1024),
                threadFactory, new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 10000; i++) {
            try {
                pool.execute(() -> {
                    System.out.println(Thread.currentThread().getName());
                    //System.out.println(pool.getPoolSize() + "个");
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Thread.sleep(11000);
        System.out.println("largestPoolSize: "+ pool.getLargestPoolSize());
        System.out.println("completedTaskCount: "+ pool.getCompletedTaskCount());
    }
}