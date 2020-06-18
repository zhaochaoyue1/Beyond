package com.example.designPattern23.factory;

/**
 * @description: SimpleVehicleFactory 简单工厂
 * 缺点：可扩展性不好；每加一个工具都要重新添加代码
 * @date: 2020/6/17 下午8:18
 * @author: zcy
 * @version: 1.0
 */
public class SimpleVehicleFactory {
    public Car createCar(){
        return new Car();
    }

    public Plane createPlane(){
        return new Plane();
    }
}
