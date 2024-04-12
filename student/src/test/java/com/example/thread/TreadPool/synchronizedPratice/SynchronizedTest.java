package com.example.thread.TreadPool.synchronizedPratice;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedTest {
    private final static Object LOCK = new Object();

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 3; i++) {

            final  int constant = i;
            new Thread(()->{
                try {
                    testWait(constant);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
        testNotify(5);
    }

    public static void testWait(int i) throws InterruptedException{
        synchronized (LOCK){
            LOCK.wait();
            System.out.println(i+"  aa");
        }
    }

    public static void testNotify(int i){
        synchronized (LOCK){
            LOCK.notify();
            System.out.println(i+ " bb");
        }
    }
}
