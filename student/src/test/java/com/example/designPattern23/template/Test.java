package com.example.designPattern23.template;

/**
 * @description: Test
 * @date: 2020/12/18 下午9:02
 * @author: zcy
 * @version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        Car car = new Car();
        Assembler assembler = new Assembler(car);
        assembler.run();
    }
}
