package com.example.designPattern23.template;

/**
 * @description: ChassisRobot
 * @date: 2020/12/18 下午8:51
 * @author: zcy
 * @version: 1.0
 */
public class ChassisRobot extends Robot {
    @Override
    protected void performance() {
        assembler.car.setChassis();
    }
}
