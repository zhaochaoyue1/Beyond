package com.example.algorithm.greedy_algorithm;

/**
 * 有两个长度一样的数组，分别对应商品的重量和价值，
 * 一个袋子最多能装x千克，求最大能装取的价值
 * @description: MaxValue
 * @date: 2022/6/1 下午5:17
 * @author: zcy
 * @version: 1.0
 */
public class MaxValue {
    public static int wight[] = new int[]{1,3,2};
    public static int price[] = new int[]{1,5,2};
    public static void main(String[] args) {
        System.out.println(getMaxValue(0,3));
    }
    public static int getMaxValue(int index,int bagWeight){
        if(index == wight.length){
            return 0;
        }
        if(wight[index]>bagWeight){
            return 0;
        }
        return Math.max(getMaxValue(index+1,bagWeight),
                price[index]+getMaxValue(index+1,bagWeight-wight[index]));
    }
}
