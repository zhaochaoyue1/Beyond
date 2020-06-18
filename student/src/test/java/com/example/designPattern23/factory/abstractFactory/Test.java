package com.example.designPattern23.factory.abstractFactory;


import com.example.designPattern23.factory.abstractFactory.ModernEntity.AK47;
import com.example.designPattern23.factory.abstractFactory.ModernEntity.Bread;
import com.example.designPattern23.factory.abstractFactory.ModernEntity.Car;
import com.example.designPattern23.factory.abstractFactory.abstractEntity.Food;
import com.example.designPattern23.factory.abstractFactory.abstractEntity.Vehicle;
import com.example.designPattern23.factory.abstractFactory.abstractEntity.Weapon;

/**
 * @description: Test
 * @date: 2020/6/17 下午6:27
 * @author: zcy
 * @version: 1.0
 *
 * 1.简单工厂：能创建对象的工厂
 * 2.静态工厂：比如单例
 * 3.工厂方法(factoryMethod) 在产品维度上扩展方便
 * 4.抽象工厂(abstractFactory) 在产品一族上进行过扩展
 */
public class Test {
    public static void main(String[] args) {
        AbstractFactory f = new ModernFactory();
        Food food = f.createFood();
        food.eat();
        Vehicle vehicle = f.createVehicle();
        vehicle.move();;
        Weapon weapon = f.createWeapon();
        weapon.shoot();
    }
}
