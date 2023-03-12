package com.example.algorithm.linked_list;

import com.alibaba.fastjson.annotation.JSONType;
import lombok.Data;

/**
 * @description: Node
 * @date: 2022/5/25 下午11:26
 * @author: zcy
 * @version: 1.0
 */
@Data
@JSONType(orders = {"value","next"})
public class Node {
    public int value;
    Node next;
    public static Node getNode(int[] arr){
        Node node = null;
        Node next = null;
        for (int i = 0; i < arr.length; i++) {
            Node node2 = new Node();
            node2.value=arr[i];
            if(node == null){
                node=node2;
                next =node2;
                continue;
            }
            next.next=node2;
            next=node2;
        }
        return node;
    }

    private static Node serializable(int[] arr){
        if(arr==null || arr.length<=0){
            return null;
        }
        Node head = null;
        Node next = null;
        for (int i = 0; i < arr.length; i++) {
            Node n = new Node(arr[i]);
            if(head == null){
                head = n;
                next = n;
                continue;
            }
            next.next = n;
            next=n;
        }
        return head;
    }

    public Node() {
    }

    public Node(int value) {
        super();
        this.value = value;
    }
}
