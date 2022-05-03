package com.example.designPattern23.proxy.serviceImpl.dynamic;

import com.example.designPattern23.proxy.service.PlayGameService;

import java.lang.reflect.Proxy;

/**
 * 动态代理模式
 * 易于扩展，但被代理类需要实现接口，接口方法扩展不需修改代理类
 * @description: PlayGameUser
 * @date: 2021/7/21 上午11:20
 * @author: zcy
 * @version: 1.0
 */
public class PlayGameUserLevel2 implements PlayGameService{

    private String name;

    public PlayGameUserLevel2(String name) {
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

    /**
     * 升级版动态代理
     * @param args
     */
    public static void main(String[] args) {
        PlayGameUserLevel2 playGameUser = new PlayGameUserLevel2("张三");
        PlayGameIH playGameIH = new PlayGameIH(playGameUser);
        PlayGameService proxy = DynamicProxy.newProxyInstance(playGameUser.getClass().getClassLoader(),playGameUser.getClass().getInterfaces(),playGameIH);
        proxy.login("张三","123456");
        proxy.kill();
        proxy.updateGrade();
    }
}
