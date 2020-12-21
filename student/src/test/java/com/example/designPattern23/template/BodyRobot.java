package com.example.designPattern23.template;

/**
 * @description: BodyRobot
 * @date: 2020/12/18 下午8:57
 * @author: zcy
 * @version: 1.0
 */
public class BodyRobot extends Robot {
    @Override
    protected void performance() {
        assembler.car.setBody();
    }
}
