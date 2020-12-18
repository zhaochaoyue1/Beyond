package com.example.designPattern23.decorate;

/**
 * @description: WithSugar
 * @date: 2020/12/18 下午3:36
 * @author: zcy
 * @version: 1.0
 */
public class WithSugar extends CoffeeDecorator {
    public WithSugar(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.5;
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + ",sugar";
    }
}
