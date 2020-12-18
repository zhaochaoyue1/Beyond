package com.example.designPattern23.decorate;

/**
 * @description: CoffeeDecorator
 * @date: 2020/12/18 下午3:34
 * @author: zcy
 * @version: 1.0
 */
public abstract class CoffeeDecorator  implements Coffee{
    protected final Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public double getCost() {
        return coffee.getCost();
    }

    @Override
    public String getIngredients() {
        return coffee.getIngredients();
    }
}
