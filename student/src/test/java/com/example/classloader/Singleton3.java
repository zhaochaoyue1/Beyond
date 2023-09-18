package com.example.classloader;

import com.alibaba.fastjson.JSONObject;

/**
 * @description: Singleton3
 * @date: 2023/8/17 下午5:13
 * @author: zcy
 * @version: 1.0
 */
public class Singleton3 {
    private static Singleton3 singleTon = new Singleton3();
    public static int count1;
    public static int count2 = 0;

    private Singleton3() {
        count1++;
        count2++;
    }

    public static Singleton3 getInstance() {
        return singleTon;
    }

    public static void main(String[] args) {
        Singleton3 singleTon = Singleton3.getInstance();
        System.out.println(JSONObject.toJSONString(singleTon));
        System.out.println("count1=" + singleTon.count1);
        System.out.println("count2=" + singleTon.count2);
        System.out.println(Singleton3.count1);
        System.out.println(Singleton3.count2);

    }
}
