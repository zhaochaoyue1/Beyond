package com.example.designPattern23.factory;

/**
 * @description: Train
 * @date: 2020/6/17 下午6:26
 * @author: zcy
 * @version: 1.0
 */
public class Train implements Move {
    @Override
    public void go() {
        System.out.println("train is running");
    }
}
