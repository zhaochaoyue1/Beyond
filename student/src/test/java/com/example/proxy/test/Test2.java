package com.example.proxy.test;

import com.example.student.project.service.RentService;
import com.example.student.project.service.impl.Landlord;
import com.example.student.project.service.impl.ProxyInvocationHandle;

/**
 * @description: Test2
 * @date: 2021/3/11 下午5:27
 * @author: zcy
 * @version: 1.0
 */
public class Test2 {
    public static void main(String[] args) {
        RentService rentService =  new Landlord();
        ProxyInvocationHandle proxyInvocationHandle = new ProxyInvocationHandle();
        RentService proxy = (RentService) proxyInvocationHandle.getProxy(rentService);
        proxy.rent();
    }
}
