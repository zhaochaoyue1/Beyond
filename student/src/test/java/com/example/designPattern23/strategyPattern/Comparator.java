package com.example.designPattern23.strategyPattern;

/**
 * description: Comparator
 * date: 2020/6/2 下午8:47
 * author: zcy
 * version: 1.0
 */
public interface Comparator<T> {
    int comparator(T o1, T o2);
}
