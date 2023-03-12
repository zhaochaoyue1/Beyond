package com.example.algorithm.sort;

import com.alibaba.fastjson.JSONObject;

/**
 * @description: MergeSort2
 * @date: 2022/11/28 下午8:45
 * @author: zcy
 * @version: 1.0
 */
public class MergeSort2 {
    public static void main(String[] args) {
        //int[] arr = new int[]{1, 3, 3, 5, 6, 3, 8, 9, 33, 44, 22, 11};
        int[] arr = new int[]{8, 9, 33, 44, 22, 11};
        sort(arr,0,arr.length-1);
        System.out.println(JSONObject.toJSONString(arr));
    }

    private static void sort(int[] arr, int i, int j) {
        if(i == j){
            return;
        }
        int mid = ((j - i) >> 1) + i;
        sort(arr,i,mid);
        sort(arr,mid+1,j);
        merge(arr,i,j,mid);
    }
    private static void merge(int[] arr,int i,int j,int mid){
        int[] help = new int[j-i+1];
        int right = mid+1;
        int index = 0;
        while(i<=mid&&right<=j){
            if(arr[i]<arr[right]){
                help[index++] = arr[i++];
            }else{
                help[index++] = arr[right++];
            }
        }
        for (; i <=mid ; i++) {
            help[index++]=arr[i];
        }
        for(;right<=j;right++){
            help[index++] = arr[right];
        }
        for (int k = help.length-1; k >= 0; k--) {
            arr[j--]=help[k];
        }
    }
}
