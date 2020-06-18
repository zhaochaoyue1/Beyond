package com.example.designPattern23.factory.abstractFactory;

import com.example.designPattern23.factory.abstractFactory.ModernEntity.AK47;
import com.example.designPattern23.factory.abstractFactory.ModernEntity.Bread;
import com.example.designPattern23.factory.abstractFactory.ModernEntity.Car;
import com.example.designPattern23.factory.abstractFactory.abstractEntity.Food;
import com.example.designPattern23.factory.abstractFactory.abstractEntity.Vehicle;
import com.example.designPattern23.factory.abstractFactory.abstractEntity.Weapon;

/**
 * @description: ModernFactory 现代工厂
 * @date: 2020/6/18 上午11:49
 * @author: zcy
 * @version: 1.0
 */
public class ModernFactory extends AbstractFactory{
    @Override
    Food createFood() {
        return new Bread();
    }

    @Override
    Vehicle createVehicle() {
        return new Car();
    }

    @Override
    Weapon createWeapon() {
        return new AK47();
    }
}
