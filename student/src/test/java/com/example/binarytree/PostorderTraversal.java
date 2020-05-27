package com.example.binarytree;

import com.alibaba.fastjson.JSONObject;
import org.assertj.core.util.Lists;

import java.util.List;
import java.util.Stack;

/**
 * 参考：https://blog.csdn.net/wang454592297/article/details/79472938
 * description: 后序遍历
 * date: 2020/5/27 下午3:16
 * author: zcy
 * version: 1.0
 */
public class PostorderTraversal {
    public static void main(String[] args) {
        TreeNode treeNode = getTreeNode();
        System.out.println(JSONObject.toJSONString(treeNode));
        //后序递归遍历
        List<Object> list = Lists.newArrayList();
        postorderTraversalRecursion(list, treeNode);
        System.out.println(JSONObject.toJSONString(list));
        //后序非递归遍历
        List<Object> list2 = Lists.newArrayList();
        postorderTraversalNotRecursion(list2, treeNode);
        System.out.println(JSONObject.toJSONString(list2));
    }

    /**
     * 后序递归遍历
     *
     * @param list
     * @param treeNode
     */
    public static void postorderTraversalNotRecursion(List<Object> list, TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.leftNode;
            }
            boolean tag = true;
            //前驱节点
            TreeNode preNode = null;
            while (!stack.isEmpty() && tag) {
                //获取栈顶数据但不移除该元素
                treeNode = stack.peek();
                //之前访问的空节点或是栈顶节点的右子节点
                if (treeNode.rightNode == preNode) {
                    treeNode = stack.pop();
                    list.add(treeNode.data);
                    if (stack.isEmpty()) {
                        return;
                    } else {
                        preNode = treeNode;
                    }
                } else {
                    treeNode = treeNode.rightNode;
                    tag = false;
                }
            }
        }
    }

    /**
     * 后续递归遍历
     *
     * @param list
     * @param treeNode
     */
    public static void postorderTraversalRecursion(List<Object> list, TreeNode treeNode) {
        if (treeNode.leftNode != null) {
            postorderTraversalRecursion(list, treeNode.leftNode);
        }
        if (treeNode.rightNode != null) {
            postorderTraversalRecursion(list, treeNode.rightNode);
        }
        list.add(treeNode.data);
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
