package com.example.designPattern23.proxy.serviceImpl.cglib;

import com.example.designPattern23.proxy.service.PlayGameService;
import com.example.designPattern23.proxy.serviceImpl.dynamic.PlayGameIH;
import com.example.designPattern23.proxy.serviceImpl.normal.PlayGameProxy;

import java.lang.reflect.Proxy;

/**
 * 动态代理模式
 * 易于扩展，但被代理类需要实现接口，接口方法扩展不需修改代理类
 * @description: PlayGameUser
 * @date: 2021/7/21 上午11:20
 * @author: zcy
 * @version: 1.0
 */
public class PlayGameUser{

    private String name;

    public PlayGameUser(String name) {
        this.name = name;
    }



    public void login(String name, String password) {
        System.out.println("登录成功！姓名：" + name +",密码：" + password);
    }


    public void kill() {
        System.out.println(name + "正在杀怪！");
    }


    public void updateGrade() {
        System.out.println(name + "已经升级！");
    }


    public PlayGameUser() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 常规CGLib动态代理
     * @param args
     */
    public static void main(String[] args) {
        PlayGameUser playGameUser = new PlayGameUser("张三");
        CglibProxy cglibProxy = new CglibProxy(playGameUser);
        PlayGameUser proxy = cglibProxy.getProxy();
        System.out.println(proxy.getName());
        proxy.login("张三","123456");
        proxy.kill();
        proxy.updateGrade();
    }
}
