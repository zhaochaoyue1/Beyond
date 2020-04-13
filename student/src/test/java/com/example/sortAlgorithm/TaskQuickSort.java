package com.example.sortAlgorithm;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TaskQuickSort {
    public static void main(String[] args) {
        Random random = new Random();
        int min=6;
        int max=10;
        HashMap<Integer, Integer> map = Maps.newHashMap();
        int diff = max - min+1;
        for (int i=0;i<5000000;i++){
            int r = random.nextInt(diff) + min;
            if(map.containsKey(r)){
                Integer value = map.get(r);
                map.put(r,value+1);
            }else {
                map.put(r,1);
            }
        }
        System.out.println(JSON.toJSONString(map));
    }

}
