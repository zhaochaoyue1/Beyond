package com.example.algorithm.MaxIsland;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @description: MaxIslandArea
 * @date: 2022/8/3 上午9:25
 * @author: zcy
 * @version: 1.0
 */
public class MaxIslandArea {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 1, 1, 1}, {1, 0, 0, 1}, {1, 0, 0, 1}, {1, 0, 1, 1}};
        print(arr);
        System.out.println(maxArea(arr));
    }

    public static int maxArea(int[][] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int[] ints = arr[i];
            for (int j = 0; j < ints.length; j++) {
                res = Math.max(res, area(arr, i, j, arr.length, ints.length));
                //res = Math.max(res,maxNonRecursion(arr,i,j,arr.length,ints.length));
            }
        }
        return res;
    }

    public static int area(int[][] arr, int i, int j, int r, int c) {
        if (i < 0 || j < 0 || i >= r || j >= c || arr[i][j] != 1) {
            return 0;
        }
        arr[i][j] = 2;
        return 1 + area(arr, i - 1, j, r, c) + area(arr, i + 1, j, r, c)
                + area(arr, i, j - 1, r, c) + area(arr, i, j + 1, r, c);
    }

    public static int maxNonRecursion(int[][] arr,int i,int j,int r,int c){
        int res = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        int[] ints = new int[]{i,j};
        queue.offer(ints);
        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            int i1 = poll[0];
            int i2 = poll[1];
            if(i1<0 || i2<0 ||i1>=r || i2>=c || arr[i1][i2]!=1){
                continue;
            }
            arr[i1][i2] = 2;
            res++;
            queue.offer(new int[]{i1-1,i2});
            queue.offer(new int[]{i1+1,i2});
            queue.offer(new int[]{i1,i2-1});
            queue.offer(new int[]{i1,i2+1});
        }
        return res;
    }



    public static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            int[] ints = arr[i];
            for (int j = 0; j < ints.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
