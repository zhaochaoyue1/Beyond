package com.example.classloader;

public class BaseCodeBlock {
    public BaseCodeBlock() {
        System.out.println("这是父类的构造方法");
    }

    public void msg() {
        System.out.println("这是父类的普通方法");
    }

    public static void msg2() {
        System.out.println("这是父类的静态方法");
    }

    static {
        System.out.println("这里是父类的静态代码块");
    }

    Other2 o2 = new Other2();
    {
        System.out.println("这里是父类普通代码块");
    }

}
