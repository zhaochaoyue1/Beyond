package com.example.algorithm.binarytree.serializable;

import com.alibaba.fastjson.JSONObject;
import com.example.algorithm.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @description: TreeNodeDeserialization
 * @date: 2022/5/28 下午8:57
 * @author: zcy
 * @version: 1.0
 */
public class TreeNodeDeserialization {
    public static void main(String[] args) {
        TreeNode deserialization = deserialization("10_6_4_#_#_8_#_#_14_12_#_#_16_#_#_");
        System.out.println(JSONObject.toJSONString(deserialization));
        String s = "a___b__c";
        System.out.println(JSONObject.toJSONString(s.split("_")));
    }

    public static TreeNode deserialization(String str){
        String[] s = str.split("_");
        Queue<Object> queue = new ArrayDeque<>();
        for (int i = 0; i < s.length; i++) {
            queue.offer(s[i]);
        }
        return reConPreOrder(queue);
    }

    public static TreeNode reConPreOrder(Queue<Object> queue){
        Object poll = queue.poll();
        if(poll.equals("#")){
            return null;
        }
        TreeNode treeNode = new TreeNode(poll);
        treeNode.leftNode = reConPreOrder(queue);
        treeNode.rightNode = reConPreOrder(queue);
        return treeNode;
    }
}
