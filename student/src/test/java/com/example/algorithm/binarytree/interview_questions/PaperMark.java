package com.example.algorithm.binarytree.interview_questions;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 微软纸痕题
 * @description: PaperMark
 * @date: 2022/5/28 下午9:23
 * @author: zcy
 * @version: 1.0
 */
public class PaperMark {
    public static void main(String[] args) {
        paperMark(1,4,true);
    }

    /**
     *
     * @param i 当前层数
     * @param n 总层数
     * @param flag true:凹 false:凸
     */
    public static void paperMark(int i,int n,boolean flag){
        if(i>n){
            return;
        }
        paperMark(i+1,n,true);
        System.out.println(flag?"凹":"凸");
        paperMark(i+1,n,false);
    }
}
