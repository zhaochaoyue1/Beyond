package com.example.algorithm.boyerMoore;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: BoyerMoore
 * @date: 2023/11/3 下午4:10
 * @author: zcy
 * @version: 1.0
 */
public class BoyerMoore {

    public static int boyerMooreSearch(String text, String pattern) {
        Map<Character, Integer> badChar = new HashMap<>();
        int patternLength = pattern.length();
        int textLength = text.length();

        // 初始化坏字符规则表
        for (int i = 0; i < patternLength; i++) {
            //字符串如果有重复的取最后的下标，这样移动可以保证最小移动对齐
            badChar.put(pattern.charAt(i), i);
        }

        int s = 0; // s 表示模式与文本对齐的位置

        while (s <= (textLength - patternLength)) {
            int j = patternLength - 1;

            // 从右往左比较字符
            while (j >= 0 && pattern.charAt(j) == text.charAt(s + j)) {
                j--;
            }

            if (j < 0) {
                // 找到匹配，返回匹配位置
                return s;
            } else {
                // 按照坏字符规则滑动模式
                int badCharIndex = badChar.getOrDefault(text.charAt(s + j), -1);
                int x = j - badCharIndex;
                int y = 1;
                if (x < y) {
                    x = y;
                }
                s += x;
            }
        }

        return -1; // 未找到匹配
    }

    public static void main(String[] args) {
        String text = "here is a simple example";//"This is a simple example for Boyer-Moore algorithm.";
        String pattern = "example";//"Boyer-Moore";
        int index = boyerMooreSearch(text, pattern);

        if (index != -1) {
            System.out.println("Pattern found at index " + index);
        } else {
            System.out.println("Pattern not found in the text.");
        }
    }
}

