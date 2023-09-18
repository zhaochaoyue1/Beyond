package com.example.javaReference;

import java.util.concurrent.TimeUnit;

/**
 * @description: ThreadLocalPractice 本地线程变量
 * @date: 2020/7/13 下午9:20
 * @author: zcy
 * @version: 1.0
 */
public class ThreadLocalPractice {
    static ThreadLocal<Person> tl = new ThreadLocal<>();

    public static void main(String[] args) {

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(tl.get());
        }).start();
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tl.set(new Person());
        }).start();
    }
}
class Person{
    String name = "张三";
}
