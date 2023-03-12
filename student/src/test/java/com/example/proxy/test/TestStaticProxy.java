package com.example.proxy.test;

import com.example.proxy.impl.AdminServiceImpl;
import com.example.proxy.impl.AdminServiceProxy;

/**
 * 静态代理模式在不改变目标对象的前提下，实现了对目标对象的功能扩展。
 * 不足：静态代理实现了目标对象的所有方法，一旦目标接口增加方法
 * ，代理对象和目标对象都要进行相应的修改，增加维护成本。
 */
public class TestStaticProxy {
    public static void main(String[] args) {
        AdminServiceImpl adminService = new AdminServiceImpl();
        AdminServiceProxy adminServiceProxy = new AdminServiceProxy(adminService);
        adminServiceProxy.find();
        System.out.println("----------分割线---------");
        adminServiceProxy.update();
    }
}
