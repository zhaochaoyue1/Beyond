package com.example.proxy.service;

import com.example.proxy.service.impl.AdminServiceImpl;

import java.lang.reflect.Proxy;

public class TesyDynamicProxy {
    public static void main(String[] args) {
        AdminService adminService = new AdminServiceImpl();
        AdminService proxy1 = (AdminService)Proxy.newProxyInstance(adminService.getClass().getClassLoader(), adminService.getClass().getInterfaces(), (proxy, method, args1) -> {
            System.out.println("方法调用前");
            Object invoke = method.invoke(adminService, args1);
            System.out.println("方法调用后");
            return invoke;
        });
        proxy1.find();
        proxy1.update();
    }
}
