package com.example.proxy.service;

import com.example.proxy.impl.AdminServiceImpl;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib底层用的是asm
 */
public class AdminServiceCglibProxy implements MethodInterceptor {
    private Object targetObject;
    private Object proxyObject;

    public Object getProxy() {
        return proxyObject;
    }

    public AdminServiceCglibProxy(Object obj){
        this.targetObject = obj;
        // 创建Enhancer对象(增强)
        Enhancer enhancer = new Enhancer();
        //设置代理目标对象
        enhancer.setSuperclass(targetObject.getClass());
        // 设置回调方法, this代表是当前类, 因为当前类实现了CallBack
        enhancer.setCallback(this);
        this.proxyObject = enhancer.create();
    }


    /**
     * @param o           代理对象
     * @param method
     * @param objects
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("----------方法调用前----------");
        //使用了fastClass
        Object invoke = methodProxy.invokeSuper(targetObject, objects);
        //使用了反射，效率低
        //Object invoke = method.invoke(targetObject, objects);
        System.out.println("----------方法调用后----------");

        return invoke;
    }
}
