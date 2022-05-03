package com.example.thread.daemon;

/**
 * 守护线程
 * https://blog.csdn.net/weixin_42400970/article/details/114446208
 * @description: DeamonPratice
 * @date: 2021/3/31 下午9:48
 * @author: zcy
 * @version: 1.0
 */
public class DaemonPractice {
    public static void main(String[] args) {
        //startDaemon();
        //stopDaemon();
        testDaemon();
    }

    public static void testDaemon(){
        try {
            Thread thread = new Thread(() -> {
                Thread thread1 = new Thread(() -> {
                    for (int i = 0; i < 1000; i++) {
                        System.out.println(i);
                    }
                });
                thread1.setDaemon(true);
                thread1.start();
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "主线程中的父线程");
            thread.start();
            //Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //开启守护线程
    public static void startDaemon(){
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(i);
            }
        }, "daemon thread start");
        System.out.println("守护线程创建成功");
        //开启守护线程
        thread.setDaemon(true);
        //启动守护线程
        thread.start();
        System.out.println("主线程结束，是否为主线程="+Thread.currentThread().isDaemon());
    }
    //关闭守护线程
    public static void stopDaemon(){
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(i);
            }
        }, "daemon thread start");
        System.out.println("守护线程创建成功");
        //关闭守护线程
        thread.setDaemon(false);
        //启动守护线程
        thread.start();
        System.out.println("主线程结束，是否为主线程="+Thread.currentThread().isDaemon());
    }
}
