package com.example.designPattern23.factory.abstractFactory.magicEntity;

import com.example.designPattern23.factory.abstractFactory.abstractEntity.Weapon;

/**
 * @description: 魔法
 * @date: 2020/6/17 下午8:43
 * @author: zcy
 * @version: 1.0
 */
public class MagicStick extends Weapon {
    public void shoot(){
        System.out.println(" is diandiandian");
    }
}
