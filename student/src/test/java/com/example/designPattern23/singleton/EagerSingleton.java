package com.example.designPattern23.singleton;

/**
 * description: EagerSingleton 饿汉式
 * date: 2020/5/30 下午7:52
 * author: zcy
 * version: 1.0
 */
public class EagerSingleton {
    private static EagerSingleton eagerSingleton = new EagerSingleton();

    private EagerSingleton() {

    }

    public static EagerSingleton getInstance() {
        return eagerSingleton;
    }
}
