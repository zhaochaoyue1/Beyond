package com.example.algorithm.sort;

import com.alibaba.fastjson.JSONObject;
import org.assertj.core.util.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @description: BinarySearch
 * @date: 2022/4/8 上午11:53
 * @author: zcy
 * @version: 1.0
 */
public class BinarySearch {
    public static void main(String[] args) {
        /*int[] arr = new int[]{323,429,969,1367,1429,2681,3042,3205,3618,3742,4142,4899,6072,6101,6157,6296,6961,7493,7800,8177,9370,9645,9784};
        System.out.println(binarySearch(arr,0,arr.length,6961));
        System.out.println(binarySearchRecursion(arr,0,arr.length,6961));*/

        /*int[] arr = new int[]{1,3,4,4,4,5,6};
        System.out.println(binarySearchLast(arr,4));;*/

        for (int i = 0; i < 100000000; i++) {
            List<Object> logarithm = logarithm();
            int[] arr = (int[])logarithm.get(0);
            int num = (int)logarithm.get(1);
            try {
                boolean b = binarySearch(arr, 0, arr.length-1, num);
                boolean c = binarySearchRecursion(arr, 0, arr.length - 1, num);
                if(b!=c){
                    System.out.println(JSONObject.toJSONString(arr));
                    System.out.println(num);
                    break;
                }
            } catch (Exception e) {
                System.out.println(JSONObject.toJSONString(arr));
                System.out.println(num);
                e.printStackTrace();
                break;
            }
        }
    }

    public static boolean binarySearchRecursion(int[] arr,int i,int j,int num){
        if(arr == null || arr.length == 0 || i>j){
            return false;
        }
        int mid = i + ((j-i)>>1);
        if(arr[mid]>num){
            return binarySearchRecursion(arr,i,mid-1,num);
        }else if(arr[mid] == num) {
            return true;
        }else {
            return binarySearchRecursion(arr,mid+1,j,num);
        }
    }

    public static boolean binarySearch(int[] arr,int i,int j,int num){
        if(arr == null || arr.length == 0){
            return false;
        }
        while(true){
            if(i>j){
                break;
            }
            int mid = i+ ((j-i)>>1);
            if(arr[mid] == num){
                return true;
            }else if(arr[mid]>num){
                j=mid-1;
            }else if(arr[mid]<num){
                i=mid+1;
            }
        }
        return false;
    }

    public static List<Object> logarithm(){
        int arrLength = 30;
        int findNum = 10000;
        List<Object> list = Lists.newArrayList();
        Random random = new Random();
        int i = random.nextInt(arrLength + 1);
        int[] arr = new int[i];
        for (int j = 0; j < i; j++) {
            arr[j] = random.nextInt(findNum+1);
        }
        Arrays.sort(arr);
        list.add(arr);
        list.add(random.nextInt(findNum));
        return list;
    }

    public static int binarySearchLast(int[] arr,int num){
        if(arr == null || arr.length == 0){
            return -1;
        }
        int index = -1;
        int i = 0 ,j =arr.length-1;
        while (true){
            int mid = i+((j-i)>>1);
            if(arr[mid]>=num){
                index = mid;
                j = mid-1;
            }else if(i >= j){
                break;
            }else {
                i=mid+1;
            }
        }
        return index;
    }

}
