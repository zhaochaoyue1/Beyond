package com.example.algorithm;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;

/**
 * @description: Test
 * @date: 2022/4/30 下午3:34
 * @author: zcy
 * @version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        String a = "what are you doing";
        char[] arr = a.toCharArray();
        //现将字符倒序排序
        for (int i = 0; i < arr.length / 2; i++) {
            arr[i] = (char) (arr[i] ^ arr[arr.length - 1 - i]);
            arr[arr.length - 1 - i] = (char) (arr[i] ^ arr[arr.length - 1 - i]);
            arr[i] = (char) (arr[i] ^ arr[arr.length - 1 - i]);
        }
        System.out.println(String.valueOf(arr));
        //在将单词的字符翻转
        for (int i = 0; i < arr.length;i++) {
            int j = i;
            while(i <= arr.length-1&&arr[i] != ' '){
                i++;
            }
            if(j==i){
                i++;
                continue;
            }
            for(int k = 0;k<(i-j)>>1;k++){
                arr[j+k]=(char)(arr[j+k]^arr[i-1-k]);
                arr[i-1-k]=(char)(arr[j+k]^arr[i-1-k]);
                arr[j+k]=(char)(arr[j+k]^arr[i-1-k]);
            }
        }
        //结果 （doing you are what）
        System.out.println(String.valueOf(arr));
    }
}
