package com.example.student.project.service.impl;

import com.example.student.project.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description: ProxyInvocationHandle
 * @date: 2021/3/11 下午4:05
 * @author: zcy
 * @version: 1.0
 */
public class ProxyInvocationHandle implements InvocationHandler {
    @Autowired
    private RentService rentService;

    public Object getProxy(RentService rentService){
        this.rentService =rentService;
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), rentService.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("住房子前的操作");
        Object invoke = method.invoke(rentService, args);
        System.out.println("租房子后的操作");
        return invoke;
    }
}
