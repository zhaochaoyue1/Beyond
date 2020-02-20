package com.example.proxy.service;

import com.example.proxy.service.impl.AdminServiceImpl;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class AdminServiceCglibProxy implements MethodInterceptor {
    private AdminServiceImpl adminServiceImpl;
    public AdminServiceCglibProxy(AdminServiceImpl adminService){
        this.adminServiceImpl = adminService;
    }
    AdminServiceImpl proxy(){
        // 创建Enhancer对象
        Enhancer enhancer = new Enhancer();
        //设置代理目标对象
        enhancer.setSuperclass(AdminServiceImpl.class);
        // 设置回调方法, this代表是当前类, 因为当前类实现了CallBack
        enhancer.setCallback(this);
        return (AdminServiceImpl) enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("----------方法调用前----------");
        Object invoke = method.invoke(adminServiceImpl, objects);
        System.out.println("----------方法调用后----------");
        return invoke;
    }
}
