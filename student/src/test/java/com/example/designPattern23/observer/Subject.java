package com.example.designPattern23.observer;

/**
 * @description: Subject 注册
 * @date: 2020/6/17 下午3:01
 * @author: zcy
 * @version: 1.0
 */
public interface Subject {

    /**
     * 注册观察者
     */
    void registerObserver(Observer observer);

    /**
     * 取消观察者
     * @param observer
     */
    void removeObserver(Observer observer);

    /**
     * 通知观察者
     */
    void notifyObserver();
}
