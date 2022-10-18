package com.example.algorithm.binarytree.binary_tree_travsersal;

import com.example.algorithm.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: MaximumDepth
 * @date: 2020/8/7 上午10:45
 * @author: zcy
 * @version: 1.0
 */
public class MaximumDepth {

    public static void main(String[] args) {
        TreeNode treeNode = getTreeNode();
        int i = maxDepth(treeNode);
        System.out.println(i);
        int weight = weight(treeNode);
        System.out.println(weight);

    }

    //递归实现
    public static int maxDepth(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(treeNode.leftNode);
            int rightHeight = maxDepth(treeNode.rightNode);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    //广度优先遍历
    public static int weight(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(treeNode);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode poll = queue.poll();
                if(poll!=null&&poll.rightNode!=null){
                    queue.offer(poll.rightNode);
                }
                if(poll!=null&&poll.leftNode!=null){
                    queue.offer(poll.leftNode);
                }
                size--;
            }
            ans++;
        }
        return ans;
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
