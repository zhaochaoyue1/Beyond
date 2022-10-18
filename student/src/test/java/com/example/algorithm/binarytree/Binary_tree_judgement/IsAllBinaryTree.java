package com.example.algorithm.binarytree.Binary_tree_judgement;

import com.example.algorithm.binarytree.TreeNode;
import lombok.Data;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 定义：层级为n时，节点数为(2^N)-1
 * 是不是满二叉树
 * @description: IsAllBinaryTree
 * @date: 2022/5/28 下午3:52
 * @author: zcy
 * @version: 1.0
 */
public class IsAllBinaryTree {

    public static void main(String[] args) {
        TreeNode allTreeNode = getAllTreeNode();
        ReturnMessage message = isAllRecursion(allTreeNode);
        System.out.println(message.nodeNum == (1<<message.level)-1);
        TreeNode noAllTreeNode = getNoAllTreeNode();
        ReturnMessage message2 = isAllRecursion(noAllTreeNode);
        System.out.println(message2.nodeNum == (1<<message2.level)-1);
    }

    public static ReturnMessage isAllRecursion(TreeNode head){
        if(head == null){
            return new ReturnMessage(0,0);
        }
        ReturnMessage leftMessage = isAllRecursion(head.leftNode);
        ReturnMessage rightMessage = isAllRecursion(head.rightNode);
        int level = Math.max(leftMessage.level,rightMessage.level) + 1;
        int nodeNum = leftMessage.nodeNum+rightMessage.nodeNum+1;
        return new ReturnMessage(level,nodeNum);
    }

    public static boolean isAllBinaryTree(TreeNode head){
        if(head == null){
            return false;
        }
        int deepNum = 0;
        int nodeNum = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(head);
        while (!queue.isEmpty()){
            deepNum++;
            int size = queue.size();
            nodeNum+=size;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if(poll.leftNode!=null){
                    queue.offer(poll.leftNode);
                }
                if(poll.rightNode!=null){
                    queue.offer(poll.rightNode);
                }
            }
        }
        return Math.pow(2,deepNum)-1 == nodeNum;
    }

    public static TreeNode getAllTreeNode() {
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

    public static TreeNode getNoAllTreeNode() {
        TreeNode treeNode = new TreeNode(7);
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(8);
        treeNode.leftNode = left;
        treeNode.rightNode = right;
        TreeNode leftLeft = new TreeNode(1);
        TreeNode leftRight = new TreeNode(2);
        left.rightNode = leftRight;
        left.leftNode = leftLeft;
        TreeNode rightLeft = new TreeNode(4);
        TreeNode rightRight = new TreeNode(9);
        right.leftNode = rightLeft;
        //right.rightNode = rightRight;
        return treeNode;
    }

    @Data
    static class ReturnMessage{
        private int level;
        private int nodeNum;
        public ReturnMessage(int level,int nodeNum){
            this.level = level;
            this.nodeNum = nodeNum;
        }
    }
}
