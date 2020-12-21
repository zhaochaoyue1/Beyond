package com.example.designPattern23.template;

/**
 * @description: Wheel
 * @date: 2020/12/18 下午8:56
 * @author: zcy
 * @version: 1.0
 */
public class WheelRobot extends Robot {
    @Override
    protected void performance() {
        assembler.car.setWheels();
    }
}
