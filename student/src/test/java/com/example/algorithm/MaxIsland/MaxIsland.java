package com.example.algorithm.MaxIsland;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 有多少个岛屿
 * @description: MaxIsland
 * @date: 2022/6/7 上午10:34
 * @author: zcy
 * @version: 1.0
 */
public class MaxIsland {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 0, 1, 1}, {1, 0, 0, 1}, {1, 0, 0, 1}, {1, 0, 1, 0}};
        print(arr);
        System.out.println("--------------------");
        System.out.println(maxLands(arr));
        print(arr);
    }

    public static int maxLands(int[][] arr){
        if(arr == null){
            return 0;
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int[] ints = arr[i];
            if(ints == null){
                return res;
            }
            for (int j = 0; j < ints.length; j++) {
                if(arr[i][j] == 1){
                    infect(arr,i,j,arr.length,ints.length);
                    res++;
                }
            }
        }
        return res;
    }

    public static void infect(int[][] arr,int i,int j,int r,int c){
        Queue<int[]> queue = new ArrayDeque<>();
        int[] ints = {i,j};
        queue.offer(ints);
        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            int i1 = poll[0];
            int i2 = poll[1];
            if(i1>=r || i2>=c || i1<0 || i2< 0|| arr[i1][i2]!=1){
                continue;
            }
            arr[i1][i2] = 2;
            queue.offer(new int[]{i1-1,i2});
            queue.offer(new int[]{i1+1,i2});
            queue.offer(new int[]{i1,i2-1});
            queue.offer(new int[]{i1,i2+1});
        }
    }

    public static int maxIsland(int[][] arr){
        int res=0;
        for (int i = 0; i < arr.length; i++) {
            int[] ints = arr[i];
            for (int j = 0; j < ints.length; j++) {
                if(arr[i][j]==1){
                    infected(arr,i,j,arr.length,ints.length);
                    //infectedQueue(arr,i,j,arr.length,ints.length);
                    res++;
                }
            }
        }
        return res;
    }

    /**
     * 递归实现
     * @param arr
     * @param i
     * @param j
     * @param r
     * @param c
     */
    public static void infected(int[][] arr, int i, int j, int r, int c) {
        if (i < 0 || j < 0 || i >= r || j >= c || arr[i][j]!=1) {
            return;
        }
        arr[i][j] = 2;
        //上
        infected(arr,i-1,j,r,c);
        //下
        infected(arr,i+1,j,r,c);
        //左
        infected(arr,i,j-1,r,c);
        //右
        infected(arr,i,j+1,r,c);
    }

    /**
     * 非递归实现
     * @param arr
     * @param i
     * @param j
     * @param r
     * @param c
     */
    public static void infectedQueue(int[][] arr, int i, int j, int r, int c){
        Queue<int[]> iQueue = new ArrayDeque<>();
        int[] ints = {i, j};
        iQueue.offer(ints);
        while (!iQueue.isEmpty()){
            int[] poll = iQueue.poll();
            i = poll[0];
            j = poll[1];
            if (i < 0 || j < 0 || i >= r || j >= c || arr[i][j]!=1) {
                continue;
            }
            arr[i][j] = 2;
            //上
            iQueue.offer(new int[]{i - 1, j});
            //下
            iQueue.offer(new int[]{i + 1, j});
            //左
            iQueue.offer(new int[]{i, j -1});
            //右
            iQueue.offer(new int[]{i, j+1});
        }
    }

    public static void print(int[][] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int[] ints = arr[i];
            for (int j = 0; j < ints.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }
}
