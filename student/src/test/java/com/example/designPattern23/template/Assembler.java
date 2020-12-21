package com.example.designPattern23.template;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: Assembler
 * @date: 2020/12/18 下午5:55
 * @author: zcy
 * @version: 1.0
 */
public class Assembler {
    List<Robot>  robots;
    Car car;
    public Assembler(Car car){
        this.car = car;
        robots = new ArrayList<>();
        robots.add(new ChassisRobot());
        robots.add(new EngineRobot());
        robots.add(new WheelRobot());
        robots.add(new BodyRobot());
    }

    public void run(){
        for (Robot robot:robots){
            robot.setAssembler(this);
            robot.assembler();
        }
    }
}
