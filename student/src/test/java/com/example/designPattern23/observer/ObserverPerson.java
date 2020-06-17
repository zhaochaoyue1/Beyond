package com.example.designPattern23.observer;

/**
 * @description: ObserverPerson
 * @date: 2020/6/17 下午4:18
 * @author: zcy
 * @version: 1.0
 */
public class ObserverPerson implements Observer {
    /**
     * 定义这个观察者的名字属性
     */
    private String name;

    /**
     * 这个具体的观察者订阅的主题
     */
    private Subject subject;

    public ObserverPerson(String name, Subject subject) {
        this.name = name;
        this.subject = subject;
        //我要注册我自己到一个指定的主题上
        subject.registerObserver(this);
    }

    @Override
    public void updateMessage(String msg) {
        System.out.println(name+"："+msg);
    }
}
