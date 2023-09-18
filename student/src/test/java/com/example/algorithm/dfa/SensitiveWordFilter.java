package com.example.algorithm.dfa;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: SensitiveWordFilter
 * @date: 2023/4/9 下午3:50
 * @author: zcy
 * @version: 1.0
 */
public class SensitiveWordFilter {
    private Node root; // DFA的根节点

    public SensitiveWordFilter() {
        root = new Node();
        // 可以从文件或数据库中加载**词库，并构建DFA
    }

    public String filter(String text) {
        StringBuilder sb = new StringBuilder(text);
        Node curr = root;
        int start = 0;
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if (!curr.children.containsKey(ch)) {
                continue;
            }
            curr = curr.children.get(ch);
            if (curr.isEnd) {
                StringBuilder sb2 = new StringBuilder();
                for (int j = start; j <= i; j++) {
                    sb2.append("*");
                }
                String asterisks = sb.toString();
                sb.replace(start, i + 1, sb2.toString());
                i = start + 1;
                curr = root;
            } else if (i == sb.length() - 1) {
                i = start + 1;
                curr = root;
            } else if (curr.children.isEmpty()) {
                i = start;
                curr = root;
            } else if (curr.children.size() == 1 && !curr.isEnd) {
                continue;
            } else {
                start = i;
            }
        }
        return sb.toString();
    }

    private static class Node {
        Map<Character, Node> children;
        boolean isEnd;

        public Node() {
            children = new HashMap<>();
            isEnd = false;
        }
    }
}
