package com.example.algorithm.sort;

import com.alibaba.fastjson.JSONObject;

/**
 * 选择排序
 * @description: SelectorSort
 * @date: 2022/3/18 上午10:19
 * @author: zcy
 * @version: 1.0
 */
public class SelectorSort {
    public static void main(String[] args) {
        int[] ints = {1, 5, 3, 4, 3, 6, 7, 2};
        sort(ints);
        System.out.println(JSONObject.toJSONString(ints));
    }

    public static void sort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
               if( arr[i] > arr[j] ){
                   arr[i] = arr[i]^arr[j];
                   arr[j] = arr[i]^arr[j];
                   arr[i] = arr[i]^arr[j];
               }
            }
        }
    }
}
