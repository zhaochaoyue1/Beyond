package com.example.classloader.zcy;

/**
 * @description: Test2
 * @date: 2020/7/10 下午9:02
 * @author: zcy
 * @version: 1.0
 */
public class Alibaba {
    public static int k = 0;
    public static Alibaba t1 = new Alibaba("t1");
    public static Alibaba t2 = new Alibaba("t2");
    public static int i = print("i");
    public static int n = 99;

    private int  a = 0;
    public int j = print("j");

    public Alibaba(String str) {
        System.out.println(++k + " : " + str + " i=" + i + " n=" + n);
        ++i;
        ++n;
    }

    {
        print("构造快");
    }

    static {
        print("静态块");
    }

    public static int print(String str) {
        System.out.println(++k + " : " + str + " i=" + i + " n=" + n);
        ++n;
        return ++i;
    }

    public static void main(String[] args) {
        Alibaba test = new Alibaba("init");
        //Alibaba init2 = new Alibaba("init2");
    }
}
