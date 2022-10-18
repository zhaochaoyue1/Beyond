package com.example.algorithm.PrintAllSubsquences;

import com.alibaba.fastjson.JSONObject;

/**
 * 打印所有的组合
 * @description: PrintAllSubsquences
 * @date: 2022/5/18 下午10:26
 * @author: zcy
 * @version: 1.0
 */
public class PrintAllSubsquences {
    public static void main(String[] args) {
        String sb = "abc";
        char[] a = new char[]{'a','b','c'};
        processor(a,0);
    }

    public static void processor(char[] str,int i){
        if(i == str.length){
            String s = String.valueOf(str);
            String s1 = s.replaceAll("\\u0000", "");
            System.out.println(s1);
            return;
        }
        processor(str,i+1);
        char temp = str[i];
        str[i] = 0;
        processor(str,i+1);
        str[i]=temp;
    }

}
