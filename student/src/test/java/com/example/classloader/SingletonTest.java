package com.example.classloader;

public class SingletonTest {
    public static void main(String[] args) {
        Singleton.getInstance();
        System.out.println("s1 value1:" + Singleton.value1);
        System.out.println("s1 value2:" + Singleton.value2);
        Singleton2.getSingleton2();
        System.out.println("s2 value1:" + Singleton2.value1);
        System.out.println("s2 value1:" + Singleton2.value2);
    }
}
