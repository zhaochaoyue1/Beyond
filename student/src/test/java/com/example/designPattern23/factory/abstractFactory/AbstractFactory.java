package com.example.designPattern23.factory.abstractFactory;

import com.example.designPattern23.factory.abstractFactory.abstractEntity.Food;
import com.example.designPattern23.factory.abstractFactory.abstractEntity.Vehicle;
import com.example.designPattern23.factory.abstractFactory.abstractEntity.Weapon;

/**
 * @description: AbstractFactory
 * @date: 2020/6/18 上午11:11
 * @author: zcy
 * @version: 1.0
 */
public abstract class AbstractFactory {
    abstract Food createFood();
    abstract Vehicle createVehicle();
    abstract Weapon createWeapon();
}
