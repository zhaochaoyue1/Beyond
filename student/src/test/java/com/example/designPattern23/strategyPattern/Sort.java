package com.example.designPattern23.strategyPattern;


/**
 * description: Sort
 * date: 2020/6/1 下午8:57
 * author: zcy
 * version: 1.0
 */
public class Sort<T> {
    public  void sort(T[] arr, Comparator<T> comparator) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (comparator.comparator(arr[min],arr[j]) == 1) {
                    min = j;
                }
            }
            if (min != i) {
                swap(arr, i, min);
            }
        }
    }

    private void swap(T[] arr, int i, int j) {
        T comparable = arr[i];
        arr[i] = arr[j];
        arr[j] = comparable;
    }
}
