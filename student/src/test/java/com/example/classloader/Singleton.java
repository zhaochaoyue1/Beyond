package com.example.classloader;

public class Singleton {
    static {
        System.out.println(Singleton.value1 +"\t" + Singleton.value2 + "\t" +Singleton.singleton);
    }
    private static Singleton singleton = new Singleton();
    public static int value1 = 5;
    public static int value2 =3;
    private Singleton(){
        value1++;
        value2++;
    }
    public static Singleton getInstance(){
        return singleton;
    }
    int count = 10;
    {
        System.out.println("count = " + count);
    }
}
