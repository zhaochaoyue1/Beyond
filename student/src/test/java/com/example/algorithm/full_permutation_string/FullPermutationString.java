package com.example.algorithm.full_permutation_string;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: FullPermutationString
 * @date: 2022/5/30 下午11:26
 * @author: zcy
 * @version: 1.0
 */
public class FullPermutationString {
    public static void main(String[] args) {
        String s = "abc" +
                "" +
                "";
        ArrayList<String> res = new ArrayList<>();
        process(s.toCharArray(),0,res);
        System.out.println(JSONObject.toJSONString(res));
    }

    public static void process(char[] str, int i, List<String> res){
        if(i == str.length){
            res.add(String.valueOf(str));
        }
        boolean[] visit = new boolean[26];
        for (int j = i; j < str.length; j++) {
            if(!visit[str[j]-'a']){
                visit[str[j]-'a']= true;
                swap(str,i,j);
                process(str,i+1,res);
                swap(str,i,j);
            }
        }
    }
    public static void swap (char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }
}
