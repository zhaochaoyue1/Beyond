package com.example.hashmap_concurrenthashmap;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: TestLoopLock
 * @date: 2021/8/18 下午5:08
 * @author: zcy
 * @version: 1.0
 */
public class TestLoopLock {
    public static void main(String[] args) {
        HashMapThread tread0 = new HashMapThread();
        HashMapThread tread1 = new HashMapThread();
        HashMapThread tread2 = new HashMapThread();
        HashMapThread tread3 = new HashMapThread();
        HashMapThread tread4 = new HashMapThread();
        tread0.start();
        tread1.start();
        tread2.start();
        tread3.start();
        tread4.start();
    }
}

class HashMapThread extends Thread{
    private static AtomicInteger ai = new AtomicInteger();
    private static Map<Integer,Integer> map = new HashM<>();
    public void run(){
        while (ai.get()<100000){
            map.put(ai.get(),ai.get());
            ai.incrementAndGet();
        }
    }
}
