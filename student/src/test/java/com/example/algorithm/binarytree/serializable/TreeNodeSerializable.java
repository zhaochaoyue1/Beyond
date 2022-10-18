package com.example.algorithm.binarytree.serializable;

import com.example.algorithm.binarytree.TreeNode;

/**
 * 二叉树序列化
 * @description: TreeNodeSerializable
 * @date: 2022/5/28 下午8:53
 * @author: zcy
 * @version: 1.0
 */
public class TreeNodeSerializable {
    public static void main(String[] args) {
        TreeNode treeNode = getTreeNode();
        System.out.println(serializable(treeNode));
    }

    public static String serializable(TreeNode head){
        if(head == null){
            return "#_";
        }
        String str = head.data+"_";
        str+=serializable(head.leftNode);
        str+=serializable(head.rightNode);
        return str;
    }

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
