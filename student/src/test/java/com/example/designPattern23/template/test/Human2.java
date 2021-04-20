package com.example.designPattern23.template.test;

/**
 * @description: Human2
 * @date: 2021/3/12 下午4:53
 * @author: zcy
 * @version: 1.0
 */
public class Human2 extends HumanAbstract{
    @Override
    void start() {
        System.out.println("human2 启动");
    }

    @Override
    void engineVoice() {
        System.out.println("human2 发动机轰鸣");
    }

    @Override
    void didi() {
        System.out.println("human2 鸣笛");
    }

    @Override
    void throttle() {
        System.out.println("human2 给油门");
    }
}
