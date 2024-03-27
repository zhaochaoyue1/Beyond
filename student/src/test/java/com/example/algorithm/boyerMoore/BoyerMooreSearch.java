package com.example.algorithm.boyerMoore;

/**
 * @description: BoyerMooreSearch
 * @date: 2023/11/7 下午8:02
 * @author: zcy
 * @version: 1.0
 */
public class BoyerMooreSearch {

    private static final int CHARSET_SIZE = 256;

    public static void badCharTable(String pattern, int[] table) {
        int len = pattern.length();
        for (int i = 0; i < CHARSET_SIZE; i++) {
            table[i] = len;
        }
        for (int i = 0; i < len - 1; i++) {
            table[pattern.charAt(i)] = len - 1 - i;
        }
    }

    public static int boyerMoore(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int[] badChar = new int[CHARSET_SIZE];
        badCharTable(pattern, badChar);

        int s = 0;
        while (s <= n - m) {
            int j = m - 1;
            while (j >= 0 && pattern.charAt(j) == text.charAt(s + j)) {
                j--;
            }
            if (j < 0) {
                return s; // 匹配成功，返回位置
            } else {
                s += Math.max(1, j - badChar[text.charAt(s + j)]);
            }
        }
        return -1; // 未匹配
    }

    public static void main(String[] args) {
        String text = "This is a sample text for Boyer-Moore algorithm.";
        String pattern = "Boyer-Moore";

        int result = boyerMoore(text, pattern);

        if (result != -1) {
            System.out.println("Pattern found at position " + result);
        } else {
            System.out.println("Pattern not found");
        }
    }
}

