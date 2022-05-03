package com.example.designPattern23.proxy.serviceImpl.ordinary;

import com.example.designPattern23.proxy.service.PlayGameService;

/**
 * 普通代理模式
 * 隐藏被代理对象,被代理对象在代理类中创建
 * @description: PlayGameUser
 * @date: 2021/7/21 上午11:20
 * @author: zcy
 * @version: 1.0
 */
public class PlayGameUser implements PlayGameService {

    private String name;

    public PlayGameUser(String name) {
        this.name = name;
    }

    @Override
    public void login(String name, String password) {
        System.out.println("登录成功！姓名：" + name +",密码：" + password);
    }

    @Override
    public void kill() {
        System.out.println(name + "正在杀怪！");
    }

    @Override
    public void updateGrade() {
        System.out.println(name + "已经升级！");
    }

    public static void main(String[] args) {
        PlayGameProxy proxy = new PlayGameProxy("张三");
        proxy.login("张三","123456");
        proxy.kill();
        proxy.updateGrade();
    }
}
