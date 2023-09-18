package com.example.thread.fork;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @description: ForkPractice
 * @date: 2023/8/23 上午10:53
 * @author: zcy
 * @version: 1.0
 */
public class ForkPractice {
    public static void main(String[] args) {
        int length = 10000;
        int[] arr  = new int[length];
        int sum = 0;
        for (int i = 0; i < length; i++) {
            arr[i]=i+1;
            sum+=i+1;
        }
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        ArraySumCalculator arrCal = new ArraySumCalculator(arr, 0, length);
        Long invoke = forkJoinPool.invoke(arrCal);
        System.out.println(invoke);
        System.out.println(sum);
    }
}

class ArraySumCalculator extends RecursiveTask<Long>{
    private final int[] arr;
    private final  int start;
    private final int end;

    public ArraySumCalculator(int[] arr,int start,int end){
        this.arr = arr;
        this.start = start;
        this.end = end;
    }


    @Override
    protected Long compute() {
        if(end - start  <= 1000){
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += arr[i];
            }
            return sum;
        }else{
            int mid = (start + end) / 2;
            ArraySumCalculator subTask1 = new ArraySumCalculator(arr, start, mid);
            ArraySumCalculator subTask2 = new ArraySumCalculator(arr, mid, end);
            invokeAll(subTask1,subTask2);
            return subTask1.join() + subTask2.join();
        }
    }

}
