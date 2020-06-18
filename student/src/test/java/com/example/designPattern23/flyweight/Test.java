package com.example.designPattern23.flyweight;

/**
 * @description: Test 享元模式
 * 将多个小对象放到池中，用到时到池中取
 * @date: 2020/6/18 下午5:30
 * @author: zcy
 * @version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        String s1 = "123";
        String s2 = "123";
        String s3 = new String("123");
        String s4 = new String("123");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s3 == s4);
        System.out.println(s1 == s3.intern());
        System.out.println(s3.intern() == s4.intern());
    }
}
