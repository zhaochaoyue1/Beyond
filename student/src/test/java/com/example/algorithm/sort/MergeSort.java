package com.example.algorithm.sort;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.Random;

/**
 * 归并排序
 * @description: MergeSort
 * @date: 2022/4/12 上午10:25
 * @author: zcy
 * @version: 1.0
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4,6,8,8,4,6,3,3};
        mergeSort(arr,0,arr.length-1);
        System.out.println(JSONObject.toJSONString(arr));
        //logarithm();
    }

    public static void logarithm(){
        Random random = new Random();
        for (int i = 0; i < 500000; i++) {
            int index = random.nextInt(100);
            int[] arr = new int[index];
            for (int j = 0; j < index; j++) {
                arr[j]=random.nextInt(100000);
            }
            int[] copy = Arrays.copyOf(arr, arr.length);
            try {
                //System.out.println(JSONObject.toJSONString(arr));
                mergeSort(arr,0,arr.length-1);
                Arrays.sort(copy);
                for (int j = 0; j < index; j++) {
                    if(arr[j]!=copy[j]){
                        System.out.println(JSONObject.toJSONString(arr));
                        System.out.println(JSONObject.toJSONString(copy));
                        System.out.println(j);
                        return;
                    }
                }
            } catch (Exception e) {
                System.out.println(JSONObject.toJSONString(arr));
                System.out.println(JSONObject.toJSONString(copy));
                e.printStackTrace();
            }
        }
    }

    public static void mergeSort(int[] arr,int i,int j){
        if(arr==null || arr.length == 0 || i == j){
            return;
        }
        int mid = i + ((j-i)>>1);
        try {
            mergeSort(arr,i,mid);
            mergeSort(arr,mid+1,j);
            merge(arr,i,j,mid);
        } catch (Exception e) {
            System.out.println(JSONObject.toJSONString(arr));
            e.printStackTrace();
        }
    }

    public static void merge(int[] arr,int i,int j,int mid){
        int[] help = new int[j-i+1];
        int helpIndex = 0;
        int m = mid+1;
        while (i<=mid&&m<=j){
            if(arr[i]<=arr[m]){
                help[helpIndex++] = arr[i++];
            }else {
                help[helpIndex++] = arr[m++];
            }
        }
        for (;i<=mid;i++){
            help[helpIndex++] = arr[i];
        }
        for (;m<=j;m++){
            help[helpIndex++] = arr[m];
        }
        for (int k = help.length-1; k >=0 ; k--) {
            arr[j--]=help[k];
        }
    }

}
