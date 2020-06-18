package com.example.designPattern23.factory.abstractFactory.magicEntity;

import com.example.designPattern23.factory.abstractFactory.abstractEntity.Vehicle;

/**
 * @description: Broom
 * @date: 2020/6/18 上午11:33
 * @author: zcy
 * @version: 1.0
 */
public class Broom extends Vehicle {
    @Override
    public void move() {
        System.out.println("broom is flying");
    }
}
