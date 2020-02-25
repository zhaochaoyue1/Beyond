package com.example.proxy.service;


import com.example.proxy.service.impl.AdminServiceImpl;
import net.sf.cglib.core.DebuggingClassWriter;

public class TestCglibProxy {
    public static void main(String[] args) {
        /*------------------------获取代理类源码-------------------------*/
        String path = AdminServiceCglibProxy.class.getResource(".").getPath();
        System.out.println(path);
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, path);

        AdminServiceImpl adminService = new AdminServiceImpl();
        AdminServiceCglibProxy proxy = new AdminServiceCglibProxy();
        Object proxy1 = proxy.getProxy(adminService);
        AdminServiceImpl a = (AdminServiceImpl) proxy1;
        a.find();
    }
}
