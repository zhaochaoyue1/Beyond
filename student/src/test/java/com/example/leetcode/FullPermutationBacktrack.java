package com.example.leetcode;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;

import java.util.LinkedList;
import java.util.List;

/**
 * description: 全排列 回溯算法
 * date: 2020/5/29 下午5:53
 * author: zcy
 * version: 1.0
 */
public class FullPermutationBacktrack {
    static List<List<Integer>> res = Lists.newLinkedList();

    public static void main(String[] args) {
        int[] arr = {1, 2};
        List<List<Integer>> permute = permute(arr);
        System.out.println(JSONObject.toJSONString(permute));
    }

    /**
     * 输入一组不重复的数值让他们全排列
     *
     * @param nums
     * @return
     */
    private static List<List<Integer>> permute(int[] nums) {
        //记录路径
        LinkedList<Integer> track = Lists.newLinkedList();
        backtrack(nums, track);
        return res;
    }

    // 路径：记录在 track 中
    // 选择列表：nums 中不存在于 track 的那些元素
    // 结束条件：nums 中的元素全都在 track 中出现
    private static void backtrack(int[] nums, LinkedList<Integer> track) {
        //触发条件
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        //这个控制当前下标，存储过哪些元素，存储过久不能在存储了
        for (int i = 0; i < nums.length; i++) {
            //排除不合法的选择
            if (track.contains(nums[i])) {
                continue;
            }
            //做选择
            track.add(nums[i]);
            //进入下一决策树
            backtrack(nums, track);
            //取消选择
            track.removeLast();
        }
    }

}
