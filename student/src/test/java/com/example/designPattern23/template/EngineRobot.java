package com.example.designPattern23.template;

/**
 * @description: EngineRobot
 * @date: 2020/12/18 下午8:56
 * @author: zcy
 * @version: 1.0
 */
public class EngineRobot extends Robot {
    @Override
    protected void performance() {
        assembler.car.setEngine();
    }
}
