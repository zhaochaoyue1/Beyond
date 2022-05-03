package com.example.binarytree;

import com.alibaba.fastjson.JSONObject;
import org.assertj.core.util.Lists;

import java.util.List;
import java.util.Stack;

/**
 * 参考:https://blog.csdn.net/wang454592297/article/details/79472938
 * description: 前序遍历二叉树
 * date: 2020/5/27 下午12:03
 * author: zcy
 * version: 1.0
 */
public class PreorderTraversal {

    public static void main(String[] args) {
        TreeNode treeNode = getTreeNode();
        System.out.println(JSONObject.toJSONString(treeNode));
        List<Object> list = Lists.newArrayList();
        //递归遍历获取值
        preorderTraversalRecursion(list, treeNode);
        System.out.println(JSONObject.toJSONString(list));
        List<Object> list2 = Lists.newArrayList();
        preorderTraversalNotRecursion(list2,treeNode);
        //前序非递归排序
        System.out.println(JSONObject.toJSONString(list2));
    }

    public static void preorderTraversalNotRecursion2(List<Object> list, TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || treeNode != null){
            while(treeNode !=null){
                list.add(treeNode.data);
                stack.push(treeNode);
                treeNode = treeNode.leftNode;
            }
            if(!stack.isEmpty()){
                treeNode = stack.pop();
                treeNode = treeNode.rightNode;
            }
        }
    }
    /**
     * 前序非递归遍历
     *
     * @param list
     * @param treeNode
     */
    public static void preorderTraversalNotRecursion(List<Object> list, TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                list.add(treeNode.data);
                stack.push(treeNode);
                treeNode = treeNode.leftNode;
            }
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.rightNode;
            }
        }
    }

    /**
     * 前序递归遍历
     *
     * @param list
     * @param treeNode
     */
    public static void preorderTraversalRecursion(List<Object> list, TreeNode treeNode) {
        list.add(treeNode.data);
        if (treeNode.leftNode != null) {
            preorderTraversalRecursion(list, treeNode.leftNode);
        }
        if (treeNode.rightNode != null) {
            preorderTraversalRecursion(list, treeNode.rightNode);
        }
    }

    /**
     * 将数组转换成二叉树
     */
    public static TreeNode tree(List<Integer> list,TreeNode treeNode){
        if(treeNode == null){
            treeNode = new TreeNode(null);
        }
        Stack<Integer> stack = new Stack<>();
        list.forEach(s->{
            if(s == null){

            }
        });
        return null;
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
