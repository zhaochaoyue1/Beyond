package com.example.algorithm.graph;

/**
 * @description: GraphGenerator
 * @date: 2022/5/29 下午10:27
 * @author: zcy
 * @version: 1.0
 */
public class GraphGenerator {
    public static Graph createGraph(int[][] matrix){
        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; i++) {
            int from = matrix[i][0];
            int to = matrix[i][1];
            int weight = matrix[i][2];
            if(!graph.nodes.containsKey(from)){
                graph.nodes.put(from,new Node(from));
            }
            if(!graph.nodes.containsKey(to)){
                graph.nodes.put(to,new Node(to));
            }
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge newEdge = new Edge(weight, fromNode, toNode);
            fromNode.nexts.add(toNode);
            fromNode.out++;
            fromNode.in++;
            fromNode.edges.add(newEdge);
            graph.edges.add(newEdge);

        }
        return graph;
    }
}
