package com.example.algorithm.sort;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.Random;

/**
 * 堆排序
 *
 * @description: HeapSort
 * @date: 2022/5/10 下午5:10
 * @author: zcy
 * @version: 1.0
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 7, 10, 8};
        for (int i = 0; i < arr.length; i++) {
            //heapInsert(arr, i);
            heapify2(arr,arr.length-1-i,arr.length);
        }

        for(int i=0;i<arr.length;i++) {
            swap(arr,0,arr.length-i-1);
            heapify2(arr,0,arr.length-i-1);
        }
        System.out.println(JSONObject.toJSONString(arr));

        for (int i = 0; i < 10000000; i++) {
            logarithm();
    }
    }

    public static void logarithm(){
        int length =10;
        int num = 10;
        int[] arr = new int[new Random().nextInt(length)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(num);
        }
        int[] originArr = Arrays.copyOf(arr, arr.length);
        int[] copyArr = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < arr.length; i++) {
            //heapInsert(arr, i);
            heapify2(arr,arr.length-1-i,arr.length);
        }

        for(int i=0;i<arr.length;i++) {
            swap(arr,0,arr.length-i-1);
            heapify2(arr,0,arr.length-i-1);
        }
        Arrays.sort(copyArr);
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=copyArr[i]){
                System.out.println(JSONObject.toJSONString(originArr));
                System.out.println(JSONObject.toJSONString(arr));
                throw new RuntimeException();
            }
        }
    }

    /**
     * 大根堆 插入
     *
     * @param arr
     * @param index
     */
    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    /**
     * 每一次从顶部移除大根堆
     * @param arr
     * @param index
     * @param size
     */
    public static void heapify(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        while(left<size){
            left = left+1<size&&arr[left+1]>arr[left]?left+1:left;
            if (arr[index] > arr[left]) {
                break;
            }
            swap(arr,index,left);
            index=left;
            left = left*2+1;
        }
    }

    /**
     * 占时还不能实现
     * 重任意部位移除大根堆的下标
     * @param arr
     */
    public static void heapify2(int[] arr, int index, int size) {

        int left = index * 2 + 1;
        while(left<size){
            left = left+1<size&&arr[left+1]>arr[left]?left+1:left;
            if (arr[index] >= arr[left]) {
                break;
            }
            swap(arr,index,left);
            index=left;
            left = left*2+1;
        }
    }


    private static void swap(int[] arr, int a, int b) {
        if (a == b) {
            return;
        }
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }
}
