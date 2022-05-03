package com.example.designPattern23.proxy.serviceImpl.dynamic;

import com.example.designPattern23.proxy.service.IAdvice;

/**
 * @description: BeforeAdvice
 * @date: 2021/7/21 下午3:16
 * @author: zcy
 * @version: 1.0
 */
public class BeforeAdvice implements IAdvice {

    @Override
    public void exec() {
        System.out.println("我是前置通知,我被执行了。");
    }
}
