package com.example.javaReference;

import java.io.IOException;

/**
 * @description: NormalReference 强引用（普通引用）
 * @date: 2020/7/13 下午8:09
 * @author: zcy
 * @version: 1.0
 */
public class NormalReference {
    public static void main(String[] args) throws IOException {
        M m = new M();
        m=null;
        System.gc();
        System.in.read();
    }
}
