package com.example.algorithm.boyerMoore;

import java.util.Arrays;

/**
 * @description: ZcyBM
 * @date: 2023/11/9 上午10:38
 * @author: zcy
 * @version: 1.0
 */
public class ZcyBM {
    public static void main(String[] args) {
        String text = "here is a simple example";
        String pattern = "example";
        int index = pattern(text, pattern);
        System.out.println(index);
        System.out.println(text.substring(index,text.length()));
    }

    private static int pattern(String text, String pattern) {
        int pLen = pattern.length();
        int tLen = text.length();
        if (tLen < pLen) {
            return -1;
        }
        int[] badTable = buildBadTable(pattern);
        int[] goodTable = buildGoodTable(pattern);
        for (int i = pLen - 1,j; i < tLen; ) {
            for (j = pLen - 1; pattern.charAt(j) == text.charAt(i); --j, --i) {
                if (j == 0) {
                    return i;
                }
            }
            i += Math.max(badTable[text.charAt(i)], goodTable[pLen - 1 - j]);
        }
        return -1;
    }

    private static int[] buildBadTable(String pattern) {
        int pLen = pattern.length();
        int[] badTable = new int[255];
        Arrays.fill(badTable, pLen);
        for (int i = 0; i < pLen - 1; i++) {
            badTable[pattern.charAt(i)] = pLen - 1 - i;
        }
        return badTable;
    }

    private static int[] buildGoodTable(String pattern) {
        int pLen = pattern.length();
        int[] goodTable = new int[pLen];
        int lastPreSuffix = pLen;
        for (int i = pLen - 1; i >= 0; --i) {
            if (isPreSuffix(pattern, i + 1)) {
                lastPreSuffix = i + 1;
            }
            goodTable[pLen - 1 - i] = lastPreSuffix - 1 - i + pLen;
        }

        for (int i = 0; i < pLen - 1; i++) {
            int sLen = suffix(pattern, i);
            goodTable[sLen] = pLen - 1 - i + sLen;
        }
        return goodTable;
    }

    private static boolean isPreSuffix(String pattern, int p) {
        int pLen = pattern.length();
        for (int j = p, i = 0; j < pLen; ++i, ++j) {
            if (pattern.charAt(i) != pattern.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    private static int suffix(String pattern, int p) {
        int pLen = pattern.length();
        int sLen = 0;
        for (int i = pLen - 1; p >= 0; --p, --i) {
            if (pattern.charAt(i) == pattern.charAt(p)) {
                sLen += 1;
            }
        }
        return sLen;
    }
}
