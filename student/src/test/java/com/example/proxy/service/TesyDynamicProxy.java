package com.example.proxy.service;

import com.example.proxy.service.impl.AdminServiceImpl;

import java.lang.reflect.Proxy;

public class TesyDynamicProxy {
    public static void main(String[] args) {
        AdminService adminService = new AdminServiceImpl();
        //System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true"); //设置系统属性
        AdminService proxy1 = (AdminService) Proxy.newProxyInstance(adminService.getClass().getClassLoader(), adminService.getClass().getInterfaces(),
                (proxy, method, args1) -> {//proxy：指的生成的代理对象（adminService） method:调用的方法 arg1：参数
            System.out.println("方法调用前");
            Object invoke = method.invoke(adminService, args1);
            System.out.println("方法调用后");
            return invoke;
        });
        proxy1.find();
        proxy1.update();
    }
}
