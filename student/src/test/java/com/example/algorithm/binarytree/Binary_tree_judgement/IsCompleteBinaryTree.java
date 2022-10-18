package com.example.algorithm.binarytree.Binary_tree_judgement;

import com.example.algorithm.binarytree.TreeNode;
import lombok.Data;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 定义（个人理解）：按照层级去看，层从左至右节点去看，出现第一个节点为null,后续节点都为null
 * 判断是否是一颗完全二叉树
 * @description: IsCompleteBinaryTree
 * @date: 2022/5/28 上午1:19
 * @author: zcy
 * @version: 1.0
 */
public class IsCompleteBinaryTree {
    public static void main(String[] args) {
        TreeNode completeTreeNode = getCompleteTreeNode();
        System.out.println(isCompleteTree2(completeTreeNode));
        System.out.println(getReturnMessage(completeTreeNode).toString());
        TreeNode noCompleteTreeNode = getNoCompleteTreeNode();
        System.out.println(isCompleteTree2(noCompleteTreeNode));
        System.out.println(getReturnMessage(noCompleteTreeNode).toString());
    }

    public static ReturnType getReturnMessage(TreeNode treeNode){
        if(treeNode == null){
            return new ReturnType(0,true,0);
        }
        ReturnType leftMessage = getReturnMessage(treeNode.leftNode);
        ReturnType rightMessage = getReturnMessage(treeNode.rightNode);
        int high = Math.max(leftMessage.high,rightMessage.high)+1;
        long num = leftMessage.num + rightMessage.num + 1;
        //左右节点有一个为false就不是
        boolean isCorrect = !leftMessage.correct || !rightMessage.correct;
        //左右两子树高度之差大于1就不是
        boolean highBool = Math.abs(leftMessage.high - rightMessage.high) > 1;
        //左树的节点数一定大于右树的节点数
        boolean isNum = leftMessage.num<rightMessage.num;
        if(isCorrect || highBool || isNum){
            return new ReturnType(high,false,num);
        }
        return new ReturnType(high,true,num);
    }

    public static boolean isCompleteTree(TreeNode node){
        if(node == null){
            return false;
        }
        boolean flag = false;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(node);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            TreeNode l = poll.leftNode;
            TreeNode r = poll.rightNode;
            if((flag&&(l != null || r != null))||(l==null&&r!=null)){
                return false;
            }
            if(l!=null){
                queue.offer(l);
            }
            if(r!=null){
                queue.offer(r);
            }
            if(l==null||r==null){
                flag=true;
            }
        }
        return true;
    }

    public static boolean isCompleteTree2(TreeNode node){
        if(node == null){
            return false;
        }
        boolean flag = false;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(node);
        int size = 0;
        while (!queue.isEmpty()){
            size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();

                TreeNode leftNode = poll.leftNode;
                if(leftNode!=null){
                    if(flag){
                        return false;
                    }
                    queue.offer(leftNode);
                }else {
                    flag=true;
                }
                TreeNode rightNode = poll.rightNode;
                if(rightNode !=null){
                    if(flag){
                        return false;
                    }
                    queue.offer(rightNode);
                }else {
                    flag=true;
                }
            }
        }
        return true;
    }

    public static TreeNode getCompleteTreeNode() {
        TreeNode treeNode = new TreeNode(5);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(10);
        treeNode.leftNode = left;
        treeNode.rightNode = right;
        TreeNode leftLeft = new TreeNode(1);
        TreeNode leftRight = new TreeNode(4);
        left.rightNode = leftRight;
        left.leftNode = leftLeft;
        TreeNode rightLeft = new TreeNode(7);
        TreeNode rightRight = new TreeNode(11);
        right.leftNode = rightLeft;
        right.rightNode = rightRight;
        return treeNode;
    }

    public static TreeNode getNoCompleteTreeNode() {
        TreeNode treeNode = new TreeNode(7);
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(8);
        treeNode.leftNode = left;
        treeNode.rightNode = right;
        TreeNode leftLeft = new TreeNode(1);
        //TreeNode leftRight = new TreeNode(2);
        //left.rightNode = leftRight;
        left.leftNode = leftLeft;
        TreeNode rightLeft = new TreeNode(4);
        TreeNode rightRight = new TreeNode(9);
        right.leftNode = rightLeft;
        right.rightNode = rightRight;
        return treeNode;
    }
    @Data
    static class ReturnType{
        private int high;
        private boolean correct;
        private long num;
        public ReturnType(int high,boolean correct,long num){
            this.high = high;
            this.correct = correct;
            this.num = num;
        }
    }
}
