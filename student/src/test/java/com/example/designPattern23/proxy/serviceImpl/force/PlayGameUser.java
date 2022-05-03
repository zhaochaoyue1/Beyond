package com.example.designPattern23.proxy.serviceImpl.force;

import com.example.designPattern23.proxy.service.PlayGameService;

/**
 * 强制代理模式
 * 被代理对象不能直接使用，代理对象需要传递到被代理对象中
 * @description: PlayGameUser
 * @date: 2021/7/21 上午11:20
 * @author: zcy
 * @version: 1.0
 */
public class PlayGameUser implements PlayGameService {

    private String name;
    private PlayGameService playGameProxy;

    public PlayGameUser(String name) {
        this.name = name;
    }

    public PlayGameService getPlayGameProxy() {
        playGameProxy = new PlayGameProxy(this);
        return playGameProxy;
    }

    @Override
    public void login(String name, String password) {
        if(playGameProxy == null){
            System.out.println("没用创建代理对象");
            return;
        }
        System.out.println("登录成功！姓名：" + name +",密码：" + password);
    }

    @Override
    public void kill() {
        if(playGameProxy == null){
            System.out.println("没用创建代理对象");
            return;
        }
        System.out.println(name + "正在杀怪！");
    }

    @Override
    public void updateGrade() {
        if(playGameProxy == null){
            System.out.println("没用创建代理对象");
            return;
        }
        System.out.println(name + "已经升级！");
    }

    public static void main(String[] args) {
        //直接用被代理对象是不能运行的
        //PlayGameUser proxy = new PlayGameUser("张三");
        PlayGameUser playGameUser = new PlayGameUser("张三");
        PlayGameService proxy = playGameUser.getPlayGameProxy();
        proxy.login("张三","123456");
        proxy.kill();
        proxy.updateGrade();
    }
}
