package com.example.algorithm.greedy_algorithm;

/**
 * 有一副扑克，可以从左边拿或者从右边，两个人都最聪明的，A先拿，B后拿
 * [1,10,3,4]
 * A一定先拿4，后数组是[1,10,3]此时B就只能拿1或3，拿完以后,A一定会那到10
 * [1,6,4]
 * A只能拿到1，4，所以B一定会拿6
 * @description: PokerAlgorithm
 * @date: 2022/5/31 下午11:53
 * @author: zcy
 * @version: 1.0
 */
public class PokerAlgorithm {
    public static void main(String[] args) {
        int[] arr = new int[]{1,10,3};
        int f = f(arr, 0, arr.length-1);
        System.out.println(f);
        int s = s(arr, 0, arr.length - 1);
        System.out.println(s);
        System.out.println(f>s);
    }

    /**
     * 先手的操作
     * @param arr
     * @param i
     * @param j
     * @return
     */
    public static int f(int[] arr,int i,int j){
        if(i == j){
            return arr[i];
        }
        return Math.max(arr[i]+s(arr,i+1,j),arr[j]+s(arr,i,j-1));
    }

    /**
     * 后手操作
     * @param arr
     * @param i
     * @param j
     * @return
     */
    public static int s(int[] arr,int i,int j){
        if(i==j){
            return 0;
        }
        //先手的第二次只能选到最小的，故后手在第一手后选的是最优饿
        return Math.min(f(arr,i+1,j),f(arr,i,j-1));
    }
}
