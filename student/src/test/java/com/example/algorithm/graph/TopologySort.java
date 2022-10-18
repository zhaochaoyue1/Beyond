package com.example.algorithm.graph;

import java.util.*;

/**
 * @description: TopologySort
 * @date: 2022/5/29 下午11:21
 * @author: zcy
 * @version: 1.0
 */
public class TopologySort {
    public static List<Node> sortedTopology(Graph graph) {
        //HashMap<> inMap = new HashMap();
        // key:某一个node
        // value: 剩余的入度
        HashMap<Node, Integer> inMap = new HashMap<>();
        // 入度为的点，才能进这个队列
        Queue<Node> zeroInQueue = new LinkedList<>();
        for (Node node : graph.nodes.values()) {
            inMap.put(node, node.in);
            if (node.in == 0) {
                zeroInQueue.add(node);
            }
        }
        //拓扑排序的结果，依次加入result
        List<Node> result = new ArrayList<>();
        while (!zeroInQueue.isEmpty()) {
            Node cur = zeroInQueue.poll();
            result.add(cur);
            for (Node next : cur.nexts) {
                inMap.put(next, inMap.get(next) - 1);
                if (inMap.get(next) == 0) {
                    zeroInQueue.add(next);
                }
            }
        }
        return result;
    }
}
