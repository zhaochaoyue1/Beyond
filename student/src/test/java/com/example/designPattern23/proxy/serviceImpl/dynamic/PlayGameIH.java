package com.example.designPattern23.proxy.serviceImpl.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @description: PlayGameIH
 * @date: 2021/7/21 下午2:29
 * @author: zcy
 * @version: 1.0
 */
public class PlayGameIH implements InvocationHandler {

    private Object obj;
    private Class cls;

    public PlayGameIH(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = method.invoke(obj, args);
        if(method.getName().equals("login")){
            System.out.println("有人登陆我的账号");
        }
        return invoke;
    }
}
