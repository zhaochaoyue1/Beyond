package com.example.designPattern23.strategyPattern;

import com.alibaba.fastjson.JSONObject;

/**
 * description: MainMethord
 * date: 2020/6/1 下午8:56
 * author: zcy
 * version: 1.0
 */
public class MainMethod {
    public static void main(String[] args) {
        Integer[] arr = {3,4,5,6,6};
        Dog[] dogs = {new Dog(2),new Dog(5),new Dog(3),new Dog(2)};
        Sort<Cat> sort = new Sort();
        Cat[] cats = {new Cat(5,5),new Cat(3,3),new Cat(4,4)};
        //按照体重排序
        sort.sort(cats,new CatWeightComparator());
        System.out.println(JSONObject.toJSONString(cats));
        sort.sort(cats,new CatHighComparator());
        //按照身高排序
        System.out.println(JSONObject.toJSONString(cats));
    }

}
