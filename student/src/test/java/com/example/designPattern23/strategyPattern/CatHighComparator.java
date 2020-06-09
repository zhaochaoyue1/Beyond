package com.example.designPattern23.strategyPattern;

/**
 * description: CatHighComparator
 * date: 2020/6/2 下午9:09
 * author: zcy
 * version: 1.0
 */
public class CatHighComparator implements Comparator<Cat> {
    @Override
    public int comparator(Cat o1, Cat o2) {
        if(o1.getHigh()>o2.getHigh()){
            return -1;
        }else if(o1.getHigh()<o2.getHigh()) {
            return 1;
        }
        return 0;
    }
}
