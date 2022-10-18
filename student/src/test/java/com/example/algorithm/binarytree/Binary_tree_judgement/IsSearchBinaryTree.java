package com.example.algorithm.binarytree.Binary_tree_judgement;

import com.example.algorithm.binarytree.TreeNode;
import lombok.Data;

/**
 * 搜索二叉树定义：二叉查找树（Binary Search Tree），
 * （又：二叉搜索树，二叉排序树）它或者是一棵空树，或者是具有下列性质的二叉树：
 * 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
 * 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
 * 是不是搜索二叉树
 * @description: IsSearchBinaryTree
 * @date: 2022/5/27 下午9:34
 * @author: zcy
 * @version: 1.0
 */
public class IsSearchBinaryTree {
    public static void main(String[] args) {
        TreeNode searchTreeNode = getSearchTreeNode();
        System.out.println(isBstRecursion(searchTreeNode));
        TreeNode noSearchTreeNode = getNoSearchTreeNode();
        System.out.println(isBstRecursion(noSearchTreeNode));
    }


    /**
     * 递归判断一颗树是否是搜索二叉树
     * @param head
     * @return
     */
    private static ReturnMessage isBstRecursion(TreeNode head){
        if(head == null){
            return null;
        }
        ReturnMessage left = isBstRecursion(head.leftNode);
        ReturnMessage right = isBstRecursion(head.rightNode);
        int cur = (Integer) head.data;
        int min = cur;
        int max = cur;
        boolean isSbt = true;
        if(left!=null){
            min = Math.min(min,left.min);
            max = Math.max(max,left.max);
        }
        if(right!=null){
            min = Math.min(min,right.min);
            max = Math.max(max,right.max);
        }
        if(left!=null&&(!left.isSbt||left.max>=cur)){
            isSbt=false;
        }
        if(right!=null&&(!right.isSbt || right.min<=cur)){
            isSbt=false;
        }
        return new ReturnMessage(isSbt,min,max);
    }

    public static Integer num = null;

    public static boolean isSbT(TreeNode head){
        if(head == null){
            return true;
        }
        boolean sbT = isSbT(head.leftNode);
        if(!sbT){
            return false;
        }
        if(num==null){
            num = (int)head.data;
        }else if((Integer) head.data<=num){
            return false;
        }else {
            num=(int)head.data;
        }
        boolean sbT1 = isSbT(head.rightNode);
        return sbT1;
    }



    public static TreeNode getSearchTreeNode() {
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

    public static TreeNode getNoSearchTreeNode() {
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
        right.rightNode = rightRight;
        return treeNode;
    }
    @Data
    static class ReturnMessage{
        private boolean isSbt;
        private int min;
        private int max;
        public ReturnMessage(boolean isSbt,int min,int max){
            this.isSbt=isSbt;
            this.min = min;
            this.max = max;
        }
    }
}
