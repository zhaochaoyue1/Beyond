package com.example.designPattern23.proxy.serviceImpl.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @description: SubjectDynamicProxy
 * @date: 2021/7/21 下午3:36
 * @author: zcy
 * @version: 1.0
 */
public class SubjectDynamicProxy extends DynamicProxy {
    public static <T> T newProxyInstance(Object o) {
        ClassLoader classLoader = o.getClass().getClassLoader();
        Class<?>[] interfaces = o.getClass().getInterfaces();
        PlayGameIH playGameIH = new PlayGameIH(o);
        return (T)newProxyInstance(classLoader,interfaces,playGameIH);
    }
}
