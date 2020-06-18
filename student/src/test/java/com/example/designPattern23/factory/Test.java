package com.example.designPattern23.factory;

/**
 * @description: Test
 * @date: 2020/6/17 下午6:27
 * @author: zcy
 * @version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        Move car = new Plane();
        car.go();

    }
}
