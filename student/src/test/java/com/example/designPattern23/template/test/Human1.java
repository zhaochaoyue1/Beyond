package com.example.designPattern23.template.test;

/**
 * @description: Human1
 * @date: 2021/3/12 下午4:51
 * @author: zcy
 * @version: 1.0
 */
public class Human1 extends HumanAbstract {
    @Override
    void start() {
        System.out.println("human1 启动");
    }

    @Override
    void engineVoice() {
        System.out.println("human1 发动机轰鸣");
    }

    @Override
    void didi() {
        System.out.println("human1 鸣笛");
    }

    @Override
    void throttle() {
        System.out.println("human1 给油门");
    }
}
