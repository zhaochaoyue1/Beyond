package com.example.designPattern23.template.test;

/**
 * @description: Test
 * @date: 2021/3/12 下午4:55
 * @author: zcy
 * @version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        Human1 human1 = new Human1();
        human1.setAlarm(true);
        human1.run();
        Human2 human2 = new Human2();
        human2.run();
    }
}
