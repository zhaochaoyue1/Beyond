package com.example.time;

import com.google.common.collect.Maps;

import java.time.LocalTime;
import java.util.HashMap;

public class TestTime {
    /*public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        int hour = now.getHour();
        int minute = now.getMinute();
        int i = hour * 60;
        int i1 = i + minute;
        int i2 = i1 / 30;
        int second = now.getSecond();
        int i3 = 30 * 60 - (minute * 60 + second);
        HashMap<Object, Object> map = Maps.newHashMap();
        System.out.println(hour);
        System.out.println(minute);
        System.out.println(i2);
        System.out.println(i3);
    }*/

    private static final TestTime instance = new TestTime();
    private boolean b = a;
    private static  boolean a = initA();

    private static boolean c = a;

    private static boolean initA() {
        return true;
    }

    private static boolean getC() {
        return c;
    }

    public static void main(String[] args) {

        System.out.println(instance.b + " " + getC());
    }
}
