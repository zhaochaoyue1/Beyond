package com.example.algorithm.binarytree;

/**
 * description: 二叉树节点
 * date: 2020/5/27 上午11:59
 * author: zcy
 * version: 1.0
 */
public class TreeNode {
    /**
     * 节点数据
     */
    public Object data;
    /**
     * 当前节点的左子节点
     */
    public TreeNode leftNode;
    /**
     * 当前节点的右子节点
     */
    public TreeNode rightNode;
    public TreeNode(Object o){
        this.data = o;
    }
}
