package com.example.designPattern23.strategyPattern;

/**
 * description: CatWeightComparator
 * date: 2020/6/2 下午9:01
 * author: zcy
 * version: 1.0
 */
public class CatWeightComparator implements Comparator<Cat> {
    @Override
    public int comparator(Cat o1, Cat o2) {
        if(o1.getWeight()>o2.getWeight()){
            return 1;
        }else if(o1.getWeight()<o2.getWeight()){
            return -1;
        }
        return 0;
    }
}

