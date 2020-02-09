package com.example.sortAlgorithm;

import org.springframework.util.StopWatch;

public class QuickSortLeft {
    public static void main(String[] args) {
        int[] arr = {78,89,100,44,77,88,66,3434};
        //int[] arr = {78,89,100,44,77,88,66};
        //int [] arr = {3,2,6,8,9,10,1};
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        sort(arr,0,arr.length-1);
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
        for(int i = 0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    private static void sort(int[] arr,int left,int right){
        if(arr == null||arr.length == 0){
            return;
        }
        if(left>right){
            return;
        }
        int l =left;
        int r = right;
        int pivot = arr[left];
        while(l!=r){
            while(arr[r]>=pivot&&l<r){
                r--;
            }
            while(arr[l]<=pivot&&l<r){
                l++;
            }
            if(l<r){
                int temp=arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }
        arr[left] = arr[l];
        arr[l] = pivot;
        sort(arr,left,l-1);
        sort(arr,l+1,right);
    }
}
