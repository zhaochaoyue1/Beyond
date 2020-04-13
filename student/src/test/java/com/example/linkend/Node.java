package com.example.linkend;

import lombok.Data;

@Data
public class Node {
    Object data;
    Node next;
    public Node(Object o){
        super();
        this.data=o;
    }
}
