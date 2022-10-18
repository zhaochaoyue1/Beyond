package com.example.algorithm.linked_list;

import com.alibaba.fastjson.JSONObject;

import java.util.Stack;

/**
 * 判断是不是回文链表
 * @description: PalindromeLinked
 * @date: 2022/5/25 下午11:25
 * @author: zcy
 * @version: 1.0
 */
public class PalindromeLinked {
    public static void main(String[] args) {
        Node node = Node.getNode(new int[]{1,2,3,2,1});
        System.out.println(JSONObject.toJSONString(node));
        System.out.println(JSONObject.toJSONString(isPalindrome3(node)));
        System.out.println(JSONObject.toJSONString(node));
    }

    public static boolean isPalindrome3(Node node){
        if(node == null || node.next == null){
            return true;
        }
        Node s = node;
        Node f = node;
        Stack<Integer> stack = new Stack<>();
        stack.push(s.value);
        while (f!=null){
            s=s.next;
            f=f.next;
            if(f==null){
                break;
            }
            stack.push(s.value);
            f = f.next;
        }
        stack.pop();
        while (!stack.isEmpty()&&s!=null){
            if(s.value != stack.pop()){
                return false;
            }
            s = s.next;
        }
        if(s!=null||!stack.isEmpty()){
            return false;
        }
        return true;
    }

    public static boolean isPalindrome2(Node head){
        if(head == null || head.next == null){
            return true;
        }
        Node s = head;
        Node f = head;
        while (f!=null){
            s = s.next;
            f=f.next;
            if(f==null){
                break;
            }
            f = f.next;
        }
        Node pre = null;
        while(s!=null){
            Node temp = s.next;
            s.next=pre;
            pre = s;
            s=temp;
        }
        Node head1 = head;
        Node pre2 = pre;
        while(pre2!=null){
            if(head1.value != pre2.value){
                return false;
            }
            head1 = head1.next;
            pre2=pre2.next;
        }
        while (pre!=null){
            Node temp = pre.next;
            pre.next=pre2;
            pre2=pre;
            pre=temp;
        }
        return true;
    }

    /**
     * 快慢指针加开辟空间
     * @param head
     * @return
     */
    public static boolean isPalindrome(Node head){
        Node s = head;
        Node f = head;
        while (f!=null){
            s=s.next;
            f=f.next;
            if(f==null){
                break;
            }
            f=f.next;
        }
        Stack<Node> stack = new Stack<>();
        while (s!=null){
            stack.push(s);
            s=s.next;
        }
        while (!stack.isEmpty()){
            Node pop = stack.pop();
            if(head.value!=pop.value){
                return false;
            }
            head = head.next;
        }
        return true;
    }

}
