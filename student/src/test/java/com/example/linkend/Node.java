package com.example.linkend;

import lombok.Data;

/**
 * 数据存储节点
 */
@Data
public class Node {
    Object data;
    Node next;

    public Node(Object o) {
        super();
        this.data = o;
    }

    /**
     * 插入节点
     *
     * @param value
     */
    public void addData(Object value) {
        Node node = new Node(value);
        node.next = this.next;
        this.next = node;
    }
}
