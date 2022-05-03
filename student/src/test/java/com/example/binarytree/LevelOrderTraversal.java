package com.example.binarytree;

import com.alibaba.fastjson.JSONObject;
import org.assertj.core.util.Lists;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * description: 层序遍历
 * date: 2020/5/27 下午5:03
 * author: zcy
 * version: 1.0
 */
public class LevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode treeNode = getTreeNode();
        System.out.println(JSONObject.toJSONString(treeNode));
        List<Object> list = Lists.newArrayList();
        levelOrderTraversal(list, treeNode);
        System.out.println(JSONObject.toJSONString(list));
    }

    public static void levelOrderTraversal(List<Object> list, TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(treeNode);
        while (!queue.isEmpty()) {
            treeNode = queue.poll();
            list.add(treeNode.data);
            if (treeNode.leftNode != null) {
                queue.offer(treeNode.leftNode);
            }
            if (treeNode.rightNode != null) {
                queue.offer(treeNode.rightNode);
            }
        }
    }

    /**
     * 对一个二叉树赋值
     *
     * @return
     */
    public static TreeNode getTreeNode() {
        TreeNode treeNode = new TreeNode(10);
        TreeNode left = new TreeNode(6);
        TreeNode right = new TreeNode(14);
        treeNode.leftNode = left;
        treeNode.rightNode = right;
        TreeNode leftLeft = new TreeNode(4);
        TreeNode leftRight = new TreeNode(8);
        left.rightNode = leftRight;
        left.leftNode = leftLeft;
        TreeNode rightLeft = new TreeNode(12);
        TreeNode rightRight = new TreeNode(16);
        right.leftNode = rightLeft;
        right.rightNode = rightRight;
        return treeNode;
    }
}
