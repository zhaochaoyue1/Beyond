package com.example.algorithm.hanoi;

/**
 * 汉诺塔打印移动过程
 * @description: Hanoi
 * @date: 2022/5/18 下午8:43
 * @author: zcy
 * @version: 1.0
 */
public class Hanoi {
    public static void main(String[] args) {
        hanoi(2);
    }

    public static void hanoi(int n){
        if(n>0){
            func(n,"左","右","中");
        }
    }

    public static void func(int i,String start,String end,String other){
        if(i==1){
            System.out.println("move 1 from " + start+" to " + end);
        }else {
            func(i-1,start,other,end);
            System.out.println("move " + i + " from " + start + " to " + end);
            func(i-1,other,end,start);
        }
    }

    private static void func2(int i,String start,String end,String other){
        if(i == 1){
            System.out.println("move 1 from " + start + " to " + end);
        }else{
            func2(i - 1, start, other, end);
            System.out.println("move " + i + " from " + start + " to " + end);
            func2(i - 1, other, end, start);
        }
    }
}
