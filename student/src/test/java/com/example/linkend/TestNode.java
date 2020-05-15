package com.example.linkend;

import com.alibaba.fastjson.JSONObject;

public class TestNode {
    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        //addHeadNode(listNode);
        //addEndNode(listNode);
        //addIndexNode(listNode);
        //deleteIndexNode(listNode);
        reverseList(listNode);
    }

    /**
     * 添加头节点
     * @param listNode
     */
    private static void addHeadNode(ListNode listNode){
        listNode.addHeadNode(1);
        listNode.addHeadNode(2);
        listNode.addHeadNode(3);
        listNode.addHeadNode(4);
        System.out.println(JSONObject.toJSONString(listNode));
    }

    /**
     * 添加头节点
     * @param listNode
     */
    private static void addEndNode(ListNode listNode){
        listNode.addEndNode(0);
        listNode.addEndNode(1);
        System.out.println(JSONObject.toJSONString(listNode));
    }

    /**
     * 按照下标添加
     */
    private static void addIndexNode(ListNode listNode){
        listNode.addEndNode(1);
        listNode.addEndNode(2);
        listNode.addIndexNode(1,3);
        System.out.println(JSONObject.toJSONString(listNode));
    }

    /**
     * 按下标删除
     */
    private static void  deleteIndexNode(ListNode listNode){
        listNode.addHeadNode(1);
        listNode.addHeadNode(2);
        listNode.addHeadNode(3);
        listNode.addHeadNode(4);
        listNode.deleteIndexNode(1);
        System.out.println(listNode);
    }

    /**
     * 原地翻转
     */
    public static void reverseList(ListNode listNode){
        listNode.addHeadNode(1);
        listNode.addHeadNode(2);
        listNode.addHeadNode(3);
        listNode.addHeadNode(4);
        System.out.println(JSONObject.toJSONString(listNode));
        listNode.reverseList();
        System.out.println(JSONObject.toJSONString(listNode));
    }

}
