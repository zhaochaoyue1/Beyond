package com.example.algorithm.binarytree.binary_tree_travsersal;

import com.example.algorithm.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @description: MaximumWidth
 * @date: 2022/5/27 下午8:43
 * @author: zcy
 * @version: 1.0
 */
public class MaximumWidth {
    public static void main(String[] args) {
        TreeNode treeNode = getTreeNode();
        System.out.println(getWidth(treeNode));
    }

    public static String getWidth(TreeNode head){
        int level = 0;
        int max =0;
        String maxStr = null;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(head);
        while (!queue.isEmpty()){
            level++;
            int size = queue.size();
            if(size>max){
                max=size;
                maxStr = level+"_"+size;
            }
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if(poll.leftNode != null){
                    queue.offer(poll.leftNode);
                }
                if(poll.rightNode != null){
                    queue.offer(poll.rightNode);
                }
            }
        }
        return maxStr;
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
