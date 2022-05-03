package com.example.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description: TestLoopLock
 * @date: 2021/8/18 下午5:08
 * @author: zcy
 * @version: 1.0
 */
public class TestLoopLock {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<Integer, String>(2);
        int n = 24 - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        map.put(n, 1+"");
        map.put(n, 2+"");
        System.out.println(6^6);
        System.out.println(n);
        ConcurrentHashMap<Integer, String> s = new ConcurrentHashMap<Integer, String>();
        s.put(1,"2");
    }
}
