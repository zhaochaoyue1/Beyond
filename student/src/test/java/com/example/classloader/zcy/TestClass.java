package com.example.classloader.zcy;

/**
 * @description: TestClass
 * @date: 2020/6/9 下午8:45
 * @author: zcy
 * @version: 1.0
 */
public class TestClass {
    /*static {
        e = 4;
        System.out.println("static code");
    }*/
    public static int e = 3;
    static {
        System.out.println("static code");
    }
    public static TestClass init = new TestClass();
    public int a = 1;
    public int b = 1;

    {
        System.out.println("common code2");
    }

    public static int c = 2;
    public static final int D = 4;
    public int h = 6;
    public int k = getInt();

    public static int getInt() {
        c++;
        return 1;
    }



    public TestClass() {
        a++;
        b++;
        c++;
    }

    public static void staticMethod() {
        System.out.println("static method");
    }

    {
        System.out.println("common code1");
    }
}

