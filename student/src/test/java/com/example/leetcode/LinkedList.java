package com.example.leetcode;

import com.alibaba.fastjson.JSONObject;

/**
 * @description: LinkedList
 * @date: 2021/9/25 下午2:31
 * @author: zcy
 * @version: 1.0
 */
public class LinkedList {
    public static void main(String[] args) {
        Node node = new Node(1);
        Node node2 = new Node(2);
        node.next=node2;
        node2.prev=node;
        Node node3 = new Node(3);
        node2.next=node3;
        node3.prev=node2;
        Node node4 = new Node(4);
        node3.next=node4;
        node4.prev=node3;
        Node node5 = new Node(5);
        node4.next=node5;
        node5.prev=node4;
        Node node6 = new Node(6);
        node5.next=node6;
        node6.prev=node5;
        Node node7 = new Node(7);
        node3.child=node7;
        Node node8 = new Node(8);
        node7.next=node8;
        node8.prev=node7;
        Node node9 = new Node(9);
        node8.next=node9;
        node9.prev=node8;
        Node node10 = new Node(10);
        node9.next=node10;
        node10.prev=node9;
        Node node11 = new Node(11);
        node8.child=node11;
        Node node12 = new Node(12);
        node11.next=node12;
        node12.prev=node11;


        Node nd = new Node();
        flatten(nd,node);
        System.out.println(JSONObject.toJSONString(nd));
    }

    public static void flatten(Node node,Node head) {
        if(head == null){
            return;
        }
        node.val = head.val;

        if(head.child != null){
            Node next = new Node();
            node.next= next;
            next.prev=node;
            flatten(next,head.child);
        }
        if(head.next != null){
            while(node.next!=null){
                node=node.next;
            }
            Node next = new Node();
            node.next= next;
            next.prev=node;
            flatten(next,head.next);
        }
    }
}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
    public Node(){
        super();
    }
    public Node(int val){
        this.val = val;
    }
};
