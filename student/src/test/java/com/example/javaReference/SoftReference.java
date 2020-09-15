package com.example.javaReference;

/**
 * @description: SoftReference 软引用 （可以用来把资源放到缓存中的）
 * @date: 2020/7/13 下午8:19
 * @author: zcy
 * @version: 1.0
 */
public class SoftReference {
    public static void main(String[] args) {
        java.lang.ref.SoftReference<byte[]> m = new java.lang.ref.SoftReference<>(new byte[1024 * 1024 * 5 ]);
        System.out.println(m.get());
        System.gc();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(m.get());
        byte[] bytes = new byte[1024 * 1024 * 10];
        System.out.println(m.get());
    }
}
