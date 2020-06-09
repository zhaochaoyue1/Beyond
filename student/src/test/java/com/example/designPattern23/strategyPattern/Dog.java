package com.example.designPattern23.strategyPattern;

import java.io.Serializable;

/**
 * description: Dog
 * date: 2020/6/2 下午8:19
 * author: zcy
 * version: 1.0
 */
public class Dog implements Comparable<Dog>, Serializable {
    private int food;

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public Dog(int food) {
        this.food = food;
    }

    @Override
    public int compareTo(Dog o) {
        if (this.food > o.food) {
            return 1;
        } else if (this.food < o.food) {
            return -1;
        } else {
            return 0;
        }
    }
}
