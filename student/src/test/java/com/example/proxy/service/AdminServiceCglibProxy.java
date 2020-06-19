package com.example.proxy.service;

import com.example.proxy.service.impl.AdminServiceImpl;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib底层用的是asm
 */
public class AdminServiceCglibProxy implements MethodInterceptor {
private Object targetObject;

    public Object getProxy(Object obj){
        this.targetObject = obj;
        // 创建Enhancer对象(增强)
        Enhancer enhancer = new Enhancer();
        //设置代理目标对象
        enhancer.setSuperclass(obj.getClass());
        // 设置回调方法, this代表是当前类, 因为当前类实现了CallBack
        enhancer.setCallback(this);
        return enhancer.create();
    }


    /**
     *
     * @param o 代理对象
     * @param method
     * @param objects
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("----------方法调用前----------");
        Object invoke = method.invoke(targetObject, objects);
        System.out.println("----------方法调用后----------");
        return invoke;
    }
}
