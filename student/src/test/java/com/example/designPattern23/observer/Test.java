package com.example.designPattern23.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: Test
 * @date: 2020/6/17 下午3:55
 * @author: zcy
 * @version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        //创建一个主题
        Sport3DSubject subject = new Sport3DSubject();

        //创建三个观察者
        Observer p1 = new ObserverPerson("zcy",subject);
        Observer p2 = new ObserverPerson("gwh",subject);
        Observer p3 = new ObserverPerson("wj",subject);

        subject.removeObserver(p3);
        subject.setMsg("你好，本期开奖结果");

    }
}
