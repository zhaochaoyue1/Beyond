package com.example.algorithm.trie;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: HashTrieTree2
 * @date: 2022/11/29 下午4:18
 * @author: zcy
 * @version: 1.0
 */
public class HashTrieTree2 {

    static class TreeNode{
        public long pass;
        public long end;
        Map<Character,TreeNode> map = new HashMap<>();
    }

    static class Trie{
        public  TreeNode treeNode;

        public  void insert(String str){
            if(StringUtils.isEmpty(str)){
                return;
            }
            char[] chars = str.toCharArray();
            treeNode.pass++;
            TreeNode head = treeNode;
            for (char aChar : chars) {
                if (head.map.get(aChar) == null) {
                    head.map.put(aChar, new TreeNode());
                }
                head = head.map.get(aChar);
                head.pass++;
            }
            head.end++;
        }

        public  long search(String str){
            if(StringUtils.isEmpty(str)){
                return 0;
            }
            char[] chars = str.toCharArray();
            TreeNode head = treeNode;
            for(char aChar: chars){
                if(head.map.get(aChar)==null){
                    return 0;
                }
                head = head.map.get(aChar);
            }
            return head.end;
        }

        public void delete(String str){
            if(search(str)<=0){
                return ;
            }
            char[] chars = str.toCharArray();
            TreeNode head = treeNode;
            head.pass--;
            for(char aChar:chars){
                if(--head.map.get(aChar).pass==0){
                    head.map.put(aChar,null);
                    return;
                }
               head = head.map.get(aChar);
            }
            head.end--;
        }
        public Trie(TreeNode treeNode){
            this.treeNode = treeNode;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie(new TreeNode());

        System.out.println("存在几个字符串：" + trie.search("abc"));

        trie.insert("abc");

        System.out.println("插入后存在几个字符串：" + trie.search("abc"));

        trie.delete("abc");

        System.out.println("删除后存在几个字符串：" + trie.search("abc"));

        trie.insert("abc");

        System.out.println("重新插入后存在几个字符串：" + trie.search("abc"));
    }

}
