package com.example.javaReference;

/**
 * @description: M
 * @date: 2020/7/13 下午8:08
 * @author: zcy
 * @version: 1.0
 */
public class M {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize");
    }
}
