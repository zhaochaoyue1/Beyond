package com.example.algorithm.sort;

import com.alibaba.fastjson.JSONObject;

/**
 * @description: BubbleSort
 * @date: 2022/3/18 上午10:38
 * @author: zcy
 * @version: 1.0
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] ints = {1, 5, 3, 4, 3, 6, 7, 2};
        sort(ints);
        System.out.println(JSONObject.toJSONString(ints));
        int[] ints2 = {1, 5, 3, 4, 3, 6, 7, 2};
        sort2(ints2);
        System.out.println(JSONObject.toJSONString(ints2));
    }

    public static void sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length -i-1; j++) {
                if(arr[j]>arr[j+1]){
                    arr[j] = arr[j+1]^arr[j];
                    arr[j+1] = arr[j+1]^arr[j];
                    arr[j] = arr[j+1]^arr[j];
                }
            }
        }
    }

    public static void sort2(int[] arr){
        for (int i = arr.length; i > 0; i--) {
            for (int j = 0; j < i-1; j++) {
                if(arr[j]>arr[j+1]){
                    arr[j] = arr[j+1]^arr[j];
                    arr[j+1] = arr[j+1]^arr[j];
                    arr[j] = arr[j+1]^arr[j];
                }
            }
        }
    }
}
