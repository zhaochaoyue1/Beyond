package com.example.algorithm.graph;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @description: Node
 * @date: 2022/5/29 下午10:14
 * @author: zcy
 * @version: 1.0
 */
public class Node {
    public int value;
    public int in;
    public int out;
    public ArrayList<Node> nexts;
    public ArrayList<Edge> edges;
    public Node(int value){
        this.value = value;
        this.in = 0;
        this.out = 0;
        this.nexts = new ArrayList<>();
        this.edges = new ArrayList<>();
    }
}
