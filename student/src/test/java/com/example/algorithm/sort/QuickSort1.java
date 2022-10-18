package com.example.algorithm.sort;

import com.alibaba.fastjson.JSONObject;
import org.checkerframework.checker.units.qual.A;

import java.util.Arrays;
import java.util.Random;

/**
 * @description: QuickSort1 快排1.0版
 * @date: 2022/5/6 下午11:15
 * @author: zcy
 * @version: 1.0
 */
public class QuickSort1 {
    public static void main(String[] args) {
        int[] arr = new int[]{2,4,5,63,3543,2};
        sortPractice(arr,0,arr.length-1);
        System.out.println(JSONObject.toJSONString(arr));
        for (int i = 0; i < 1000000; i++) {
            logarithm();
        }
    }

    public static void logarithm(){
        int random = 10000000;
        int length = 101;
        int[] arr = new int[new Random().nextInt(length)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(random);
        }
        int[] copyArr = Arrays.copyOf(arr, arr.length);
        sortPractice(arr,0,arr.length-1);
        Arrays.sort(copyArr);
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=copyArr[i]){
                throw new RuntimeException();
            }

        }
    }

    public static void sort(int[] arr,int left,int right){
        if(left<0||right<1||left>=right){
            return;
        }
        int pi = left-1;
        int pj = right;
        int i = left;
        int j = right-1;
        int num = arr[right];
        while(i<pj){
            if(arr[i] < num){
                i++;
                pi++;
                continue;
            }
            if(arr[i]>=num){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                pj--;
                j--;
            }
        }
        int temp =arr[pi+1];
        arr[pi+1]=arr[right];
        arr[right]=temp;
        sort(arr,left,pj-1);
        sort(arr,pj+1,right);
    }

    public static void sortPractice(int[] arr,int left,int right){
        if(right-left<1){
            return;
        }
        int pi = left-1;
        int i = left;
        int pj = right;
        int j = right-1;
        int num = arr[right];
        while(i<pj){
            if(arr[i]<num){
                pi++;
                i++;
                continue;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            j--;
            pj--;
        }
        int temp = arr[right];
        arr[right] = arr[pj];
        arr[pj] = temp;
        sortPractice(arr,left,pj-1);
        sortPractice(arr,pj+1,right);
    }
}
