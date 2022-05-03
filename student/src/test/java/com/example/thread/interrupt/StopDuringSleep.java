package com.example.thread.interrupt;

/**
 * @description: StopDuringSleep
 * @date: 2022/4/19 下午3:23
 * @author: zcy
 * @version: 1.0
 */
public class StopDuringSleep {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                int num = 0 ;
                while (!Thread.currentThread().isInterrupted()&&num<=1000){
                    System.out.println("num = " + num++);
                    Thread.sleep(100000000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
