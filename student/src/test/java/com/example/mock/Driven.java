package com.example.mock;

/**
 * @description: Driven
 * @date: 2021/5/17 下午5:42
 * @author: zcy
 * @version: 1.0
 */
public class Driven implements IDriven {

    @Override
    public void driven(ICar car) {
        car.run();
        System.out.println("开始行使");
    }
}
