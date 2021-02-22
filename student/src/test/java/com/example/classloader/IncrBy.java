package com.example.classloader;

/**
 * @description: IncrBy
 * @date: 2021/1/27 下午8:12
 * @author: zcy
 * @version: 1.0
 */
public class IncrBy {
    public static void main(String[] args) {
        int a = 2;
        int b = a++ + a * 3;
        System.out.println(b);
        int c = 2;
        int d = ++c + c * 3;
        System.out.println(d);
    }
}
