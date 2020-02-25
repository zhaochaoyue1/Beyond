package com.example.classloader;

public class Singleton2 {
    {
        System.out.println(Singleton2.value1 + "\t" +Singleton2.value2 + "\t" + Singleton2.singleton2);
    }
    public static int value1 = 5;
    public static int value2 = 3;
    private static Singleton2 singleton2= new Singleton2();
    int count =20;
    {
        System.out.println("count = "+ count);
    }
    private Singleton2(){
        value1++;
        value2++;
    }
    public static Singleton2 getSingleton2(){
        return singleton2;
    }
}
