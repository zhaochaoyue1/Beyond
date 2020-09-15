package com.example.leetcode;

import org.assertj.core.util.Lists;

import java.util.List;

/**
 * description: 八皇后-回溯算法
 * date: 2020/5/30 下午4:48
 * author: zcy
 * version: 1.0
 */
public class BacktrackQueen {
    private static int[][] chess = new int[8][8];
    private static List<List<Integer>> chessPattern = Lists.newArrayList();
    public static void main(String[] args) {

    }

    public static void queen(List<Integer> list, int n) {
        if (list.size() == n) {
            chessPattern.add(list);
            return;
        }
        for (int i = 0; i <= n; i++) {
            //list
        }
    }
}
