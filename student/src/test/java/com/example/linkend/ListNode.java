package com.example.linkend;

import lombok.Data;

@Data
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val){
        super();
        this.val=val;
    }
}
