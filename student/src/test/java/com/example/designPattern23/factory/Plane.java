package com.example.designPattern23.factory;

/**
 * @description: Plane
 * @date: 2020/6/17 下午6:25
 * @author: zcy
 * @version: 1.0
 */
public class Plane implements Move {
    @Override
    public void go() {
        System.out.println("plane is flying");
    }
}
