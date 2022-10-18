package com.example.algorithm.binarytree.Binary_tree_judgement;

import com.example.algorithm.binarytree.TreeNode;
import lombok.Data;

/**
 * 是否是平衡二叉树
 * @description: IsAvgBinaryTree
 * @date: 2022/5/28 下午4:05
 * @author: zcy
 * @version: 1.0
 */
public class IsAvgBinaryTree {
    public static void main(String[] args) {
        TreeNode avgTreeNode = getAvgTreeNode();
        System.out.println(isAvgBinaryTree(avgTreeNode).isAvg);
        TreeNode noAvgTreeNode = getNoAvgTreeNode();
        System.out.println(isAvgBinaryTree(noAvgTreeNode).isAvg);
    }

    private static ReturnType isAvgBinaryTree(TreeNode head){
        if(head == null){
            return new ReturnType(0,true);
        }

        ReturnType leftReturn = isAvgBinaryTree(head.leftNode);
        ReturnType rightReturn = isAvgBinaryTree(head.rightNode);

        int high = Math.max(leftReturn.getHigh(),rightReturn.getHigh())+1;
        boolean isAvgTree = leftReturn.isAvg&&rightReturn.isAvg&&
                Math.abs((leftReturn.high-rightReturn.high))<2;
        return new ReturnType(high,isAvgTree);
    }

    public static TreeNode getAvgTreeNode() {
        TreeNode treeNode = new TreeNode(5);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(10);
        treeNode.leftNode = left;
        treeNode.rightNode = right;
        TreeNode leftLeft = new TreeNode(1);
        TreeNode leftRight = new TreeNode(4);
        left.leftNode = leftLeft;
        left.rightNode = leftRight;
        TreeNode rightLeft = new TreeNode(7);
        TreeNode rightRight = new TreeNode(11);
        right.leftNode = rightLeft;
        right.rightNode = rightRight;
        return treeNode;
    }

    public static TreeNode getNoAvgTreeNode() {
        TreeNode treeNode = new TreeNode(7);
        //TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(8);
        //treeNode.leftNode = left;
        treeNode.rightNode = right;
        TreeNode leftLeft = new TreeNode(1);
        TreeNode leftRight = new TreeNode(2);
        //left.rightNode = leftRight;
        //left.leftNode = leftLeft;
        TreeNode rightLeft = new TreeNode(4);
        TreeNode rightRight = new TreeNode(9);
        right.leftNode = rightLeft;
        right.rightNode = rightRight;
        return treeNode;
    }
    @Data
    static class ReturnType{
        private int high;
        private boolean isAvg;
        public ReturnType(int high,boolean isAvg){
            this.high = high;
            this.isAvg = isAvg;
        }
    }
}
