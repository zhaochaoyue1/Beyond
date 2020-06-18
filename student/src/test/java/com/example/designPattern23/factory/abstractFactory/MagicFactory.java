package com.example.designPattern23.factory.abstractFactory;

import com.example.designPattern23.factory.abstractFactory.AbstractFactory;
import com.example.designPattern23.factory.abstractFactory.abstractEntity.Food;
import com.example.designPattern23.factory.abstractFactory.abstractEntity.Vehicle;
import com.example.designPattern23.factory.abstractFactory.abstractEntity.Weapon;
import com.example.designPattern23.factory.abstractFactory.magicEntity.Broom;
import com.example.designPattern23.factory.abstractFactory.magicEntity.MagicStick;
import com.example.designPattern23.factory.abstractFactory.magicEntity.MushRoom;

/**
 * @description: MagicFactory 魔法工厂
 * @date: 2020/6/18 上午11:52
 * @author: zcy
 * @version: 1.0
 */
public class MagicFactory extends AbstractFactory {
    @Override
    Food createFood() {
        return new MushRoom();
    }

    @Override
    Vehicle createVehicle() {
        return new Broom();
    }

    @Override
    Weapon createWeapon() {
        return new MagicStick();
    }
}
