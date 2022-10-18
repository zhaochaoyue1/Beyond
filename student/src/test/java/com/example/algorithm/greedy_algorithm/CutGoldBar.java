package com.example.algorithm.greedy_algorithm;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 切割金条
 * @description: CutGoldBar
 * @date: 2022/5/30 下午4:49
 * @author: zcy
 * @version: 1.0
 */
public class CutGoldBar {

    public static void main(String[] args) {
        int[] ints = {30, 20, 10};
        System.out.println(lessMoney(ints));
    }

    public static int lessMoney(int[] arr){
        //使用小根堆
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            queue.offer(arr[i]);
        }
        int num = 0;
        while (queue.size()>1){
            int sum = queue.poll() + queue.poll();
            queue.offer(sum);
            num+=sum;
        }
        return num;
    }
}
