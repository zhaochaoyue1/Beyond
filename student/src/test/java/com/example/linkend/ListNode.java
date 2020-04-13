package com.example.linkend;

import lombok.Data;

@Data
public class ListNode {
    int val;
    ListNode next;
    public ListNode(int val){
        super();
        this.val=val;
    }
}
