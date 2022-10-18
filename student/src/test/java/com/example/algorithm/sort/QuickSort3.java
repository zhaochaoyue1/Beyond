package com.example.algorithm.sort;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.Random;

/**
 * @description: QuickSort3
 * @date: 2022/5/8 下午10:30
 * @author: zcy
 * @version: 1.0
 */
public class QuickSort3 {
    public static void main(String[] args) {
        int[] arr = new int[]{30,46,88,30};
        System.out.println(arr.length);
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
        int index = new Random().nextInt(right - left + 1) + left;
        swap(arr,index,right);
        int num = arr[right];
        int pi=left-1;
        int i = left;
        int j = right-1;
        int pj = right;
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

    private static void swap(int[] arr ,int a,int b){
        if(a == b){
            return;
        }
        arr[a]=arr[a]^arr[b];
        arr[b] = arr[a]^arr[b];
        arr[a] = arr[a]^arr[b];
    }
    public static void logarithm(){
        int random = 100;
        int length = 5;
        int[] arr = new int[new Random().nextInt(length)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(random);
        }
        int[] origin = Arrays.copyOf(arr, arr.length);
        int[] copyArr = Arrays.copyOf(arr, arr.length);
        sort(arr,0,arr.length-1);
        Arrays.sort(copyArr);
        try {
            for (int i = 0; i < arr.length; i++) {
                if(arr[i]!=copyArr[i]){
                    throw new RuntimeException();
                }

            }
        } catch (RuntimeException e) {
            System.out.println(JSONObject.toJSONString(origin));
            System.out.println(JSONObject.toJSONString(arr));
            System.out.println(JSONObject.toJSONString(copyArr));
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
