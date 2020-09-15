package com.example.classloader.javaObjectLayout;

import org.openjdk.jol.info.ClassLayout;

/**
 * @description: 利用Java object layout 工具查看一个对象在jvm里的布局
 * @date: 2020/7/11 下午4:46
 * @author: zcy
 * @version: 1.0
 */
public class Test {

    public static void main(String[] args) {
        Object o = new Object();
        /*java.lang.Object object internals:
        OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
        0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
        4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
        8     4        (object header)                           d5 01 00 f8 (11010101 00000001 00000000 11111000) (-134217259)
        12     4        (loss due to the next object alignment)
        Instance size: 16 bytes
        Space losses: 0 bytes inte rnal + 4 bytes external = 4 bytes total*/
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        synchronized (o) {
            /*java.lang.Object object internals:
            OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
            0     4        (object header)                           d0 e8 30 0b (11010000 11101000 00110000 00001011) (187754704)
            4     4        (object header)                           00 70 00 00 (00000000 01110000 00000000 00000000) (28672)
            8     4        (object header)                           d5 01 00 f8 (11010101 00000001 00000000 11111000) (-134217259)
            12     4        (loss due to the next object alignment)
            Instance size: 16 bytes
            Space losses: 0 bytes internal + 4 bytes external = 4 bytes total*/
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }
}