package com.example.designPattern23.decorate;

/**
 * @description: WithMilk
 * @date: 2020/12/18 下午3:35
 * @author: zcy
 * @version: 1.0
 */
public class WithMilk extends CoffeeDecorator {

    public WithMilk(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost()+1;
    }

    @Override
    public String getIngredients() {
        return super.getIngredients()+",milk";
    }
}
