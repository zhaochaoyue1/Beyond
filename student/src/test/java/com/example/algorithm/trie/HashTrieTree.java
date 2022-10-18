package com.example.algorithm.trie;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * hashMap实现前缀树
 *
 * @description: HashTrieTree
 * @date: 2022/6/6 下午4:54
 * @author: zcy
 * @version: 1.0
 */
public class HashTrieTree {
   static class TreeNode {
        public int pass;
        public int end;
        public HashMap<Character, TreeNode> map;

        public TreeNode() {
            this.map = new HashMap<>();
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("a");
        System.out.println(JSONObject.toJSONString(trie.root));
        //trie.insert("a");
        //System.out.println(JSONObject.toJSONString(trie.root));
        int a = trie.search("a");
        System.out.println(a);
        trie.delete("a");
        System.out.println(JSONObject.toJSONString(trie.root));
        //trie.insert("a");
        //System.out.println(JSONObject.toJSONString(trie.root));
        Map<String,String> maps = Maps.newHashMap();
        maps.put(null,null);
        System.out.println(maps.containsKey(null));
        System.out.println(maps.containsValue(null));
        System.out.println(JSONObject.toJSONString(maps));
        maps.remove(null);
        System.out.println(maps.containsKey(null));
        System.out.println(maps.containsValue(null));
        System.out.println(JSONObject.toJSONString(maps));
        maps.put("1",null);
        System.out.println(maps.containsKey("1"));
        System.out.println(maps.containsValue(null));
        System.out.println(JSONObject.toJSONString(maps));
    }

   static class Trie {
        public TreeNode root;

        public Trie() {
            this.root = new TreeNode();
        }

        public void insert(String word) {
            if (StringUtils.isEmpty(word)) {
                return;
            }
            if (root == null) {
                root = new TreeNode();
            }
            char[] chars = word.toCharArray();
            root.pass++;
            TreeNode head = root;
            for (int i = 0; i < chars.length; i++) {
                char str = chars[i];
                if (head.map.get(str) == null) {
                    head.map.put(str, new TreeNode());
                }
                head = head.map.get(str);
                head.pass++;
            }
            head.end++;
        }

        public int search(String word) {
            if (StringUtils.isEmpty(word) || root == null) {
                return 0;
            }
            char[] chars = word.toCharArray();
            TreeNode head = root;
            for (int i = 0; i < chars.length; i++) {
                char str = chars[i];
                if (head.map.get(str) == null) {
                    return 0;
                }
                head = head.map.get(str);
            }
            return head.end;
        }

        public void delete(String word) {
            if (StringUtils.isEmpty(word) || root == null) {
                return;
            }
            if (search(word) <= 0) {
                return;
            }
            char[] chars = word.toCharArray();
            TreeNode head = root;
            root.pass--;
            for (int i = 0; i < chars.length; i++) {
                char str = chars[i];
                if(--head.map.get(str).pass == 0){
                    head.map.put(str,null);
                    return;
                }
                head = head.map.get(str);
            }
            head.end--;
        }
    }
}
