package com.example.designPattern23.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: Sport3DSubject
 * @date: 2020/6/17 下午3:12
 * @author: zcy
 * @version: 1.0
 */
public class Sport3DSubject implements Subject {
    private String msg;
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        //校验这个观察者是否在集合中,数组为空时返回-1
        int i = observers.indexOf(observer);
        if (i > -1) {
            observers.remove(i);
        }
    }

    @Override
    public void notifyObserver() {
        observers.forEach(s -> s.updateMessage(msg));
    }

    /**
     * 给福彩对象设置要发送的消息
     *
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
        //通知观察者
        notifyObserver();
    }
}
