package com.example.proxy.impl;

import com.example.proxy.service.AdminService;

public class AdminServiceImpl implements AdminService {
    @Override
    public void update() {
        System.out.println("这是一个修改方法");
    }

    @Override
    public Object find() {
        System.out.println("这是一个查询方法");
        return null;
    }

    public  void staticMethod(){
        System.out.println("这是一个静态方法");
    }
}
