package com.example.algorithm.boyerMoore;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;

/**
 * @description: BoyerMoore2
 * @date: 2023/11/3 下午5:07
 * @author: zcy
 * @version: 1.0
 */
import java.util.ArrayList;
import java.util.List;

public class BoyerMoore2 {

    private static final int NO_OF_CHARS = 256;

    public static int[] buildBadCharTable(String pattern) {
        int[] badChar = new int[NO_OF_CHARS];
        Arrays.fill(badChar, -1);

        for (int i = 0; i < pattern.length(); i++) {
            badChar[pattern.charAt(i)] = i;
        }

        return badChar;
    }

    public static int[] buildGoodSuffixTable(String pattern) {
        int patternLength = pattern.length();
        int[] goodSuffix = new int[patternLength];
        int[] suff = new int[patternLength];

        int f = 0;
        int g = patternLength - 1;

        for (int i = patternLength - 2; i >= 0; i--) {
            if (i > g && suff[i + patternLength - 1 - f] < i - g) {
                suff[i] = suff[i + patternLength - 1 - f];
            } else {
                if (i < g) {
                    g = i;
                }
                f = i;

                while (g >= 0 && pattern.charAt(g) == pattern.charAt(g + patternLength - 1 - f)) {
                    g--;
                }

                suff[i] = f - g;
            }
        }
        System.out.println(JSONObject.toJSONString(suff));
        // 构建好后缀表（goodSuffix），根据suff数组计算
        for (int i = 0; i < patternLength; i++) {
            goodSuffix[i] = patternLength;
        }

        for (int i = patternLength - 1; i >= 0; i--) {
            if (suff[i] == i + 1) {
                for (int j = 0; j < patternLength - 1 - i; j++) {
                    if (goodSuffix[j] == patternLength) {
                        goodSuffix[j] = patternLength - 1 - i;
                    }
                }
            }
        }

        for (int i = 0; i <= patternLength - 2; i++) {
            goodSuffix[patternLength - 1 - suff[i]] = patternLength - 1 - i;
        }

        return goodSuffix;
    }



    public static List<Integer> boyerMooreSearch(String text, String pattern) {
        List<Integer> occurrences = new ArrayList<>();
        int m = pattern.length();
        int n = text.length();
        int[] badChar = buildBadCharTable(pattern);
        int[] goodSuffix = buildGoodSuffixTable(pattern);
        System.out.println(JSONObject.toJSONString(goodSuffix));
        int s = 0;
        while (s <= n - m) {
            int j = m - 1;
            while (j >= 0 && pattern.charAt(j) == text.charAt(s + j)) {
                j--;
            }
            if (j < 0) {
                occurrences.add(s);
                s += (s + m < n) ? m - badChar[text.charAt(s + m)] : 1;
            } else {
                s += Math.max(goodSuffix[j], j - badChar[text.charAt(s + j)]);
            }
        }

        return occurrences;
    }

    public static void main(String[] args) {
        String text = "abdccbac";//"This is a simple example for Boyer-Moore algorithm. Boyer-Moore is efficient.";
        String pattern = "aaaaaa";//"Boyer-Moore";
        List<Integer> occurrences = boyerMooreSearch(text, pattern);

        if (!occurrences.isEmpty()) {
            System.out.println("Pattern found at positions: " + occurrences);
        } else {
            System.out.println("Pattern not found in the text.");
        }
    }
}
