package com.example.algorithm.binarytree.binary_tree_travsersal;

import com.alibaba.fastjson.JSONObject;
import com.example.algorithm.binarytree.TreeNode;
import org.assertj.core.util.Lists;

import java.util.List;
import java.util.Stack;

/**
 * 参考：https://blog.csdn.net/wang454592297/article/details/79472938
 * description: 中序遍历
 * date: 2020/5/27 下午2:59
 * author: zcy
 * version: 1.0
 */
public class InorderTraversal {
    public static void main(String[] args) {
        TreeNode treeNode = getTreeNode();
        System.out.println(JSONObject.toJSONString(treeNode));
        List<Object> list = Lists.newArrayList();
        //中序递归排序
        inOrderPrint(list, treeNode);
        System.out.println(JSONObject.toJSONString(list));
        //中序非递归排序
        List<Object> list2 = Lists.newArrayList();
        inorderTraversalNotRecursion(list2,treeNode);
        System.out.println(JSONObject.toJSONString(list2));
    }

    public static void inOrderPrint(List<Object> list,TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()){
            if(node != null){
                stack.push(node);
                node = node.leftNode;
            }
            if(node == null&&!stack.isEmpty()){
                TreeNode pop = stack.pop();
                list.add(pop.data);
                node = pop.rightNode;
            }
        }
    }


    /**
     * 中序非递归遍历
     *
     * @param list
     * @param treeNode
     */
    public static void inorderTraversalNotRecursion(List<Object> list, TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.leftNode;
            }
            if(!stack.isEmpty()){
                treeNode = stack.pop();
                list.add(treeNode.data);
                treeNode = treeNode.rightNode;
            }
        }
    }

    /**
     * 中序递归遍历
     *
     * @param list
     * @param treeNode
     */
    public static void inorderTraversalRecurise(List<Object> list, TreeNode treeNode) {
        if (treeNode.leftNode != null) {
            inorderTraversalRecurise(list, treeNode.leftNode);
        }
        list.add(treeNode.data);
        if (treeNode.rightNode != null) {
            inorderTraversalRecurise(list, treeNode.rightNode);
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
