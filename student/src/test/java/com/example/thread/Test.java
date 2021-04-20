package com.example.thread;

import org.apache.tools.ant.taskdefs.Sleep;

import java.lang.reflect.Field;

/**
 * @description: Test
 * @date: 2021/3/17 下午5:30
 * @author: zcy
 * @version: 1.0
 */
public class Test implements  Runnable{
    private String name;
    public Test(String name){
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(name + i);
        }
    }
}

class Test2{
    public static void main(String[] args) {
        Test test = new Test("线程1:");
        Test test2 = new Test("线程2:");
        Thread thread = new Thread(test);
        Thread thread1 = new Thread(test2);
        thread.start();
        thread1.start();
    }
}

class Test3{
    private static int a;
    public synchronized static void add(int y){
        try {
            Thread.sleep(y);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ++a;
        String name = Thread.currentThread().getName();
        System.out.println(name + "线程:" + a);
    }
    public Test3(String x){
        System.out.println(System.currentTimeMillis()/1000 + ":" + x);
    }
}

class Test4{
    public static void main(String[] args) {
        new Thread(()->{
            System.out.println("线程1："+ System.currentTimeMillis()/1000);
            Test3.add(10000);
            //Test3 test3 = new Test3("1");
        },"线程1").start();

        new Thread(()->{
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Test3 test3 = new Test3("2");
            System.out.println("线程2："+ System.currentTimeMillis()/1000);
            Test3 test = new Test3("2");
            synchronized (Test3.class){}
            System.out.println("线程2："+ System.currentTimeMillis()/1000);
            //Test3.add(0);
        },"线程2").start();
    }
}

class Test5{
    public int a;
}

class test6{
    public static void main(String[] args) {
        //Test5 test5 = new Test5();
        new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                //++test5.a;
                System.out.println("线程1：");
            }

        }).start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                //++test5.a;
                System.out.println("线程2：");
            }
        }).start();
    }
}

