package com.example.designPattern23.proxy.serviceImpl.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @description: DynamicProxy
 * @date: 2021/7/21 下午3:27
 * @author: zcy
 * @version: 1.0
 */
public class DynamicProxy<T> {
    public static <T> T newProxyInstance(ClassLoader classLoader, Class[] interfaces, InvocationHandler h) {
        new BeforeAdvice().exec();
        return (T) Proxy.newProxyInstance(classLoader, interfaces, h);
    }
}
