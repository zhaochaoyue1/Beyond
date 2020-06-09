package com.example.designPattern23.strategyPattern;

/**
 * description: Cat
 * date: 2020/6/2 下午8:20
 * author: zcy
 * version: 1.0
 */
public class Cat implements Comparable<Cat> {
    private int weight;
    private int high;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public Cat(int weight, int high) {
        this.weight = weight;
        this.high = high;
    }

    @Override
    public int compareTo(Cat o) {
        if (this.weight > o.weight) {
            return 1;
        } else if (this.weight < o.weight) {
            return -1;
        } else {
            return 0;
        }
    }
}
