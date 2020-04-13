package com.example.linkend;

import com.alibaba.fastjson.JSON;

public class TestLinkedList {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addHead(1);
        singleLinkedList.addEnd(2);
        singleLinkedList.addEnd(3);
        singleLinkedList.remove(0);
        System.out.println(JSON.toJSONString(singleLinkedList));
    }
}
