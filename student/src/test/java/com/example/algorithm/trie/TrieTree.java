package com.example.algorithm.trie;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.sql.Struct;

/**
 * /前缀树
 * @description: TrieTree
 * @date: 2022/5/30 上午12:36
 * @author: zcy
 * @version: 1.0
 */
public class TrieTree {

    //前缀数节点
   static class TrieNode{
        //通过几次
        public int pass;
        //结束过几次
        public int end;
        public TrieNode[] nexts;

        public TrieNode(){
            pass = 0;
            end = 0;
            //这个是处理字母的所以要开阔的空间是26
            nexts = new TrieNode[26];
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("a");
        System.out.println(JSONObject.toJSONString(trie.root));
        int a = trie.search("a");
        System.out.println(a);
        trie.delete("a");
        System.out.println(JSONObject.toJSONString(trie.root));
    }

    //路径上的信息
   static class Trie{

        public TrieNode root;
        public Trie(){
            root = new TrieNode();
        }

        //前缀数插入
        public void insert(String word){
            if(StringUtils.isEmpty(word)){
                return;
            }
            char[] chars = word.toCharArray();

            TrieNode head = root;
            root.pass++;
            for (int i = 0; i < chars.length; i++) {
                int index = chars[i]-'a';
                if(head.nexts[index] == null){
                    //index就是a
                    head.nexts[index] = new TrieNode();
                }
                head = head.nexts[index];
                head.pass++;
            }
            head.end++;
        }

        //查询一个字符出现过几次
        public int search(String word){
            if(StringUtils.isEmpty(word)){
                return 0;
            }

            TrieNode head = root;
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int index = chars[i]-'a';
                if(head.nexts[index] == null){
                    return 0;
                }
                head=head.nexts[index];
            }
            return head.end;
        }

        //所有加入的字符串中，有几个是以pre这个字符串作为前缀的
        public int prefixNumber(String pre){
            if(StringUtils.isEmpty(pre)){
                return 0;
            }
            char[] chars = pre.toCharArray();
            TrieNode head = root;
            for (int i = 0; i < chars.length; i++) {
                int index = chars[i]-'a';
                if(head.nexts[index] == null){
                    return 0;
                }
                head = head.nexts[index];
            }
            return head.pass;
        }

        //删除一个字符串
        public void delete(String word){
            if(StringUtils.isEmpty(word)){
                return;
            }
            //存在这个字符
            if(search(word)>0){
                char[] chars = word.toCharArray();
                TrieNode head = root;
                head.pass--;
                for (int i = 0; i < chars.length; i++) {
                    int index = chars[i]- 'a';
                    if(--head.nexts[index].pass == 0){
                        head.nexts[index] = null;
                        return;
                    }
                    head = head.nexts[index];
                }
                head.end--;
            }
        }
    }
}
