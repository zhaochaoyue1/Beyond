package com.example.proxy.test;


import com.example.proxy.impl.AdminServiceImpl;
import com.example.proxy.service.AdminService;

import java.lang.reflect.Proxy;

/**
 * https://blog.51cto.com/u_15281317/2942363
 * jdk 动态代理： 其代理对象必须是某个接口的实现，它是通过在运行期间创建一个接口的实现
 * 类来完成对目标对象的代理
 */
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
