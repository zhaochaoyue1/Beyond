package com.example.proxy.service;

import com.example.proxy.service.impl.AdminServiceImpl;

public class TestCglibProxy {
    public static void main(String[] args) {
        AdminServiceImpl adminService = new AdminServiceImpl();
        AdminServiceImpl proxy = new AdminServiceCglibProxy(adminService).proxy();
        proxy.find();
        proxy.update();
    }
}
