package com.example.leetcode;

import org.apache.commons.lang3.StringUtils;

/**
 * @description: Resubstr
 * @date: 2021/2/3 上午11:17
 * @author: zcy
 * @version: 1.0
 */
public class Resubstr {
    /**
     * 设置变量
     * start 开始
     * end 结束
     * maxStart 最长子串开始位置
     * maxEnd 最长子串结束位置
     */
    private static int start = 0, end = 0, maxStart = 0, maxEnd = 0;

    public static void main(String[] args) {
        String a = "bbccbb;";
        int two = two(a, 2);
        System.out.println(two);
    }

    /**
     * 查询字符串连续最长字符
     * @param a
     */
    private static void one(String a){
        if (StringUtils.isBlank(a)) {
            return;
        }
        if (a.length() == 1) {
            return;
        }
        for (int i = 0; i < a.length() - 1; i++) {
            if (a.charAt(i) == a.charAt(i + 1)) {
                end++;
                continue;
            }
            if (end - start >= maxEnd - maxStart) {
                maxStart=start;
                maxEnd = end;
            }
            start=i+1;
            end=start;
        }
        System.out.println(maxStart+","+maxEnd);
    }

    /**
     * 替换字符串中的几个字符后，最大连续字符长度
     * @param s
     * @param k
     * @return
     */
    public static int two(String s,int k){
        int[] num = new int[26];
        int n = s.length();
        int maxn = 0;
        int left = 0, right = 0;
        while (right < n) {
            num[s.charAt(right) - 'A']++;
            maxn = Math.max(maxn, num[s.charAt(right) - 'A']);
            if (right - left + 1 - maxn > k) {
                num[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }
        return right - left;
    }
}
