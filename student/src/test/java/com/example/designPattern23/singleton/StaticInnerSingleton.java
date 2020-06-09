package com.example.designPattern23.singleton;

/**
 * description: StaticInnerSingleton 静态内部类
 * jvm保证多线程下安全
 * 加载外部类不会加载内部类，这样可以实现懒加载
 * date: 2020/5/30 下午8:00
 * author: zcy
 * version: 1.0
 */
public class StaticInnerSingleton {
    private StaticInnerSingleton() {

    }

    /**
     * 静态内部类
     */
    private static class StaticInner {
        private final static StaticInnerSingleton INSTANCE = new StaticInnerSingleton();
    }

    /**
     * 调用静态内部类
     *
     * @return
     */
    public static StaticInnerSingleton getInstance() {
        return StaticInner.INSTANCE;
    }
}
