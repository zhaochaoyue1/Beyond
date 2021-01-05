package com.example.designPattern23.template;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: Assembler
 * @date: 2020/12/18 下午5:55
 * @author: zcy
 * @version: 1.0
 *
 *  抽象是面向对象编程的核心思想，从某种角度来看，抽象，就是把可变的部分和不可变的部分分离开，已达到以不变应万变的效果。
 *  实现了代码的解耦，使扩展和维护更加方便。
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
