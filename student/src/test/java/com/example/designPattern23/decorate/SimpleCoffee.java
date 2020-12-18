package com.example.designPattern23.decorate;

/**
 * @description: SimpleCoffee
 * @date: 2020/12/18 下午3:33
 * @author: zcy
 * @version: 1.0
 */
public class SimpleCoffee implements Coffee {
    @Override
    public double getCost() {
        return 1;
    }

    @Override
    public String getIngredients() {
        return "coffee";
    }
}
