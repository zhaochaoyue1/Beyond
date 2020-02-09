package com.example.sortAlgorithm;

import org.springframework.util.StopWatch;

import java.util.Random;

public class QuickSortRight {
    public static void main(String[] args) {
        /*int[] arr = new int[10000];
        for(int i =0;i<10000;i++){
            Random random = new Random();
            int i1 = random.nextInt(10000);
            arr[i] = i1;
        }*/
        int[] arr = {1,3,3,6,78,89,100,44,77,88,66,3434};
        //int[] arr = {78,89,100,44,77,88,66};
        //int [] arr = {3,2,6,8,9,10,1};
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        quickSort(arr,0,arr.length-1);
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
        for(int i = 0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    private static void quickSort(int[] arr,int left,int right){
        if(arr == null || arr.length ==0){
            return;
        }
        if(left>right){
            return;
        }
        int pivot = getPartition(arr, left, right);
        quickSort(arr,left,pivot-1);
        quickSort(arr,pivot+1,right);
    }

    private static int getPartition(int[] a,int left,int right){
        int pivot=a[right];//先定义区间数组第一个元素为主元
        int i=left;   //定义最低的索引low是first+1。比主元大一位
        int j=right;     //定义最高的索引high是last
        while(i!=j){   //当low小于high的位置时，执行以下循环
            while(a[i]<=pivot&&i<j){//当low的索引上的值比主元小时，索引小于high时
                i++;                       //寻找比主元大的值的位置索引。
            }
            while(a[j]>=pivot&&i<j){//当high的索引上的值比主元大时，且索引大于low时
                j--;                      //寻找比主元小的值的位置索引
            }
            if(i<j){   //交换low和high的值
                int t=a[i];
                a[i]=a[j];
                a[j]=t;
            }
        }
        a[right]=a[i];
        a[i]=pivot;
        return i;
    }
}
