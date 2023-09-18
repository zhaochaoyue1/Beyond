package com.example.algorithm.sort;

import com.alibaba.fastjson.JSONObject;
import com.example.student.Student;

/**
 * 插入排序
 * @description: InsertSort
 * @date: 2022/4/6 上午10:29
 * @author: zcy
 * @version: 1.0
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4,5,6,3,2};
        insertSort(arr);
        System.out.println(JSONObject.toJSONString(arr));
    }


    public static void insertSort(int[] arr){
        if(arr == null || arr.length ==1){
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0&&arr[j]<arr[j-1]; j--) {
                swap(arr,j,j-1);
            }
        }
    }

    public static void swap(int[] arr,int i,int j){
        arr[i] = arr[i]^arr[j];
        arr[j] = arr[i]^arr[j];
        arr[i] = arr[i]^arr[j];
    }

}
