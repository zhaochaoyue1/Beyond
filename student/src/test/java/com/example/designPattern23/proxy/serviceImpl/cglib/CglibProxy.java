package com.example.designPattern23.proxy.serviceImpl.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @description: CglibProxy
 * @date: 2021/7/21 下午4:00
 * @author: zcy
 * @version: 1.0
 */
public class CglibProxy implements MethodInterceptor {
    private Object obj;

    public  Object proxy;

    public CglibProxy(Object obj) {
        this.obj = obj;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(obj.getClass());
        enhancer.setCallback(this);
        proxy = enhancer.create();
    }


    public <T> T getProxy() {
        return (T)proxy;
    }

    public void setProxy(Object proxy) {
        this.proxy = proxy;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println(method.getName() + " 方法调用前");
        Object invoke = method.invoke(obj, objects);
        System.out.println(method.getName() + " 方法调用后");
        return invoke;
    }
}
