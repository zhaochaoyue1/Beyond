package com.example.designPattern23.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: Test 组合模式（用来处理数组）
 * @date: 2020/6/18 下午4:19
 * @author: zcy
 * @version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        BranchNode root = new BranchNode("root");
        BranchNode chapter1 = new BranchNode("chapter1");
        BranchNode chapter2 = new BranchNode("chapter2");
        Node c11 = new LeafNode("c11");
        Node c12 = new LeafNode("c12");
        BranchNode section21 = new BranchNode("section21");
        Node c211 = new LeafNode("c211");
        Node c212 = new LeafNode("c212");

        root.add(chapter1);
        root.add(chapter2);
        chapter1.add(c11);
        chapter1.add(c12);
        chapter2.add(section21);
        section21.add(c211);
        section21.add(c212);

        tree(root,0);
    }

    private static void tree(Node node,int length){
        for (int i = 0; i < length; i++) {
            System.out.printf("--");
        }
        node.p();
        length++;
        if(node instanceof BranchNode){
            for(Node n:((BranchNode) node).nodes){
                tree(n,length);
            }
        }
    }

}
abstract class Node{
    public abstract void p();
}

class LeafNode extends Node{
    String content;

    public LeafNode(String content) {
        this.content = content;
    }
    @Override
    public void p() {
        System.out.println(content);
    }
}

class BranchNode extends Node{
     List<Node> nodes = new ArrayList<>();
     String name;

    public BranchNode(String name) {
        this.name = name;
    }

    @Override
    public void p() {
        System.out.println(name);
    }

    public void add(Node n){
        nodes.add(n);
    }
}

