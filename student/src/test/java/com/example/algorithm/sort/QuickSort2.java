package com.example.algorithm.sort;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.Random;

/**
 * @description: QuickSort2
 * @date: 2022/5/8 下午10:11
 * @author: zcy
 * @version: 1.0
 */
public class QuickSort2 {
    public static void main(String[] args) {
       int[] arr = new int[]{1,3,-1,34,2,3,53,2,30,33,55,3454};
       sort(arr,0,arr.length-1);
        System.out.println(JSONObject.toJSONString(arr));

        for (int i = 0; i < 1000000; i++) {
            logarithm();
        }
    }

    public static void sort(int[] arr,int left,int right){
        if(right-left<1){
            return;
        }
        int pi = left-1;
        int i = left;
        int pj = right;
        int j = right-1;
        int num = arr[right];
        while (i<pj){
            if(arr[i] == num){
                i++;
                continue;
            }
            if(arr[i]>num){
                swap(arr,i,j);
                j--;
                pj--;
                continue;
            }
            swap(arr,pi+1,i);
            i++;
            pi++;
        }
        swap(arr,right,pj);
        sort(arr,left,pi);
        sort(arr,pj,right);
    }

    public static void logarithm(){
        int random = 10000000;
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

    private static void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
