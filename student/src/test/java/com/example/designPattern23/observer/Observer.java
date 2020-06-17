package com.example.designPattern23.observer;

/**
 * @description: Observer 观察者
 * @date: 2020/6/17 下午3:04
 * @author: zcy
 * @version: 1.0
 */
public interface Observer {
    /**
     * 观察者更新消息
     * @param msg
     */
    void updateMessage(String msg);
}

