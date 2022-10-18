package com.example.algorithm.sort;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.Random;

/**
 * @description: QuickSort
 * @date: 2022/5/26 下午2:38
 * @author: zcy
 * @version: 1.0
 */
public class QuickSort4 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,5,3};
        sort(arr,0,arr.length-1);
        System.out.println(JSONObject.toJSONString(arr));
        logarithm();
    }

    public static void logarithm(){
        int random = 100000000;
        int length = 101;
        int[] arr = new int[new Random().nextInt(length)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(random);
        }
        int[] copyArr = Arrays.copyOf(arr, arr.length);
        sort(arr,0,arr.length-1);
        Arrays.sort(copyArr);
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=copyArr[i]){
                throw new RuntimeException();
            }

        }
    }

    public static void sort(int[] arr,int left,int right){
        if(right-left<1){
            return;
        }
        int randIndex = new Random().nextInt(right - left + 1) + left;
        swap(arr,randIndex,right);
        int l=left;
        int rp = right;
        while(l<rp){
            if(arr[l]<arr[right]){
                l++;
            }else {
                swap(arr,l,rp-1);
                rp--;
            }
        }
        swap(arr,rp,right);
        sort(arr,left,rp-1);
        sort(arr,rp+1,right);
    }

    public static void swap(int[] arr ,int a,int b){
        if(a == b){
            return;
        }
        arr[a] = arr[a]^arr[b];
        arr[b] = arr[a]^arr[b];
        arr[a] = arr[a]^arr[b];
    }

}
