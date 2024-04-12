package com.example.thread.abstractQueueSynchronizer;

import org.apache.tools.ant.taskdefs.Sleep;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class AbsPractice {
    static ReentrantLock reentrantLock = new ReentrantLock(true);
    public static void main(String[] args) {
        /*ReentrantLock reentrantLock = new ReentrantLock(true);
        reentrantLock.lock();*/
        First first = new First(reentrantLock);
        first.start();
        Second second = new Second(reentrantLock);
        second.start();
    }
}

class First extends Thread{

    private  ReentrantLock reentrantLock;

    public First(ReentrantLock reentrantLock) {
        this.reentrantLock = reentrantLock;
    }

    @Override
    public void run() {
        /*try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/

        reentrantLock.lock();
        try {
            TimeUnit.SECONDS.sleep(60*60);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            reentrantLock.unlock();
        }
    }
}

class Second extends Thread{
    private  ReentrantLock reentrantLock;

    public Second(ReentrantLock reentrantLock) {
        this.reentrantLock = reentrantLock;
    }
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        reentrantLock.lock();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            reentrantLock.unlock();
        }
    }
}