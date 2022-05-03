package com.example.thread.interrupt;

/**
 * @description: StopThread
 * @date: 2022/4/19 下午3:18
 * @author: zcy
 * @version: 1.0
 */
public class StopThread implements Runnable {
    @Override
    public void run() {
        int count = 0;
        while(!Thread.currentThread().isInterrupted()&&count<1000){
            System.out.println("count = " + count++);
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new StopThread());
        thread.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
