package com.example.bigdecimal;


import java.math.BigDecimal;

public class TestBigDecimal {
    public static void main(String[] args) {
        //testNumAndString();
        testDistinction();
    }
    //测试bigDecimal 整数与小数的区别
    public static void testDistinction(){
        BigDecimal a = new BigDecimal("22.1899");
        System.out.println(a.intValueExact());
        System.out.println(a.scale());
    }
    //测试数值与字符串的区别
    private static void testNumAndString(){
        BigDecimal b = new BigDecimal("0.1");
        BigDecimal c = new BigDecimal(0.1);
        BigDecimal f = new BigDecimal(1);
        String str = "1000000000000000055511151231257827021181583404541015625";
        StringBuilder sb = new StringBuilder("1");
        for(int i=0;i<str.length()-1;i++){
            sb.append(0);
        }
        BigDecimal d = new BigDecimal(sb.toString());
        BigDecimal e = c.multiply(d);
        System.out.println(b);
        System.out.println(c);
        System.out.println(e);
        System.out.println(b.equals(c));
        System.out.println(f.scale());
        System.out.println(c.setScale(1,BigDecimal.ROUND_DOWN));
        System.out.println(b.equals(c.setScale(1,BigDecimal.ROUND_DOWN)));
    }
}
