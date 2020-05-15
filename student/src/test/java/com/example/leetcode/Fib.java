package com.example.leetcode;

import java.util.*;

public class Fib {
    public static void main(String[] args) {
        int n = 42;
        Map<Integer,Integer> map = new HashMap<>();
        int fib = fibDynamicProgramming(n, map);
        //int fib = fib(n);
        System.out.println(fib);
    }

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static int fibDynamicProgramming(int n, Map<Integer,Integer> map) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (map.get(n) == null) {
            map.put(n, fibDynamicProgramming(n - 1,map) + fibDynamicProgramming(n - 2,map));
        }
        return map.get(n);
    }
}
