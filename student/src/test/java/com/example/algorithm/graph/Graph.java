package com.example.algorithm.graph;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @description: Graph
 * @date: 2022/5/29 下午10:24
 * @author: zcy
 * @version: 1.0
 */
public class Graph {
    public HashMap<Integer,Node> nodes;
    public HashSet<Edge> edges;
    public Graph(){
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
