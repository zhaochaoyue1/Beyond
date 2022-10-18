package com.example.algorithm.graph;

/**
 * @description: Edge
 * @date: 2022/5/29 下午10:20
 * @author: zcy
 * @version: 1.0
 */
public class Edge {
    public int weight;
    public Node from;
    public Node to;
    public Edge(int weight,Node from,Node to){
        this.weight = weight;
        this.from = from;
        this.to  = to;
    }
}
