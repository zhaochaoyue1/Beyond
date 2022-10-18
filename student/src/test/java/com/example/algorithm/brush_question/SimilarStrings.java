package com.example.algorithm.brush_question;

/**
 * 字符串相似度
 * 题目来源：https://leetcode.cn/problems/k-similar-strings/solution/zhua-wa-mou-si-by-muse-77-b79a/
 * @description: SimilarStrings
 * @date: 2022/9/22 上午10:11
 * @author: zcy
 * @version: 1.0
 */
public class SimilarStrings {

    static int result = Integer.MAX_VALUE;
    public static int kSimilarity(String s1, String s2) {
        return execute(s1.toCharArray(), s2.toCharArray(), 0, 0);
    }

    public static int execute(char[] sc1, char[] sc2, int start, int current) {
        if (current >= result) return result; // 如果交换次数已经超过"目前最小交换次数result"，终止递归
        if (start == sc1.length - 1) return result = Math.min(current, result);

        for (int i = start; i < sc1.length; i++) {
            if (sc1[i] != sc2[i]) {
                for (int j = i + 1; j < sc2.length; j++) {
                    if (sc2[j] == sc1[i] && sc2[j] != sc1[j]) {
                        swap(sc2, i, j); // 交换
                        execute(sc1, sc2, i + 1, current + 1);
                        swap(sc2, i, j); // 回溯
                        //sc2[j] == sc1[i]已确定且sc2[j] != sc1[j]故(sc2[i] == sc1[j]时是最优的解
                        if (sc2[i] == sc1[j]) break; // 如果sc1和sc2的i位于j位互为相等，那么就是最优交换
                    }
                }
                return result;
            }
        }
        return result = Math.min(current, result);
    }

    public static void swap(char[] sc, int i, int j){
        char temp = sc[i];
        sc[i] = sc[j];
        sc[j] = temp;
    }

    public static void main(String[] args) {
        String s1 = "abccd";
        String s2 = "dcbac";

        System.out.println(kSimilarity(s1,s2));
    }

}
