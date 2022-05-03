package com.example.designPattern23.proxy.serviceImpl.normal;

import com.example.designPattern23.proxy.service.PlayGameService;

/**
 * 常规的代理模式
 * 扩展性差，扩展业务接口方法，代理也需要扩展接口方法
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
        PlayGameService playGameService = new PlayGameUser("张三");
        PlayGameProxy proxy = new PlayGameProxy(playGameService);
        proxy.login("张三","123456");
        proxy.kill();
        proxy.updateGrade();
    }
}
