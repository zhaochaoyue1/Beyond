package com.example.leetcode;

import org.apache.commons.lang3.StringUtils;

public class StringSwap {
    public static void main(String[] args) {
        String s ="the sky is blue";
        System.out.println(reverseWords(s));
    }

    private static String reverseWords(String s) {
        String[] s1 = s.split(" ");
        int length = s1.length;
        String sb = "";
        for (int i = length - 1; i >= 0; i--) {
            String s2 = s1[i];
            if(s2!=null&&s2.equals(" ")&&s2.length()>0){
                if(!sb.equals("")||sb.length()>0){
                    sb=sb+ " "+s2;
                }else {
                    sb = s2;
                }
            }
        }
        return sb;
    }
}
