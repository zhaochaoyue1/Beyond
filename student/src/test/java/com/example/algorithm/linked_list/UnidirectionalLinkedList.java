package com.example.algorithm.linked_list;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONType;
import lombok.Data;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * 单向链表逆序
 *
 * @description: UnidirectionalLinkedList
 * @date: 2022/5/25 下午12:02
 * @author: zcy
 * @version: 1.0
 */
public class UnidirectionalLinkedList {
    public static void main(String[] args) {
        Node node = Node.getNode(new int[]{1, 2, 3});
        System.out.println(JSONObject.toJSONString(node));
        Node re = getRecursion(node);
        System.out.println(JSONObject.toJSONString(re));
    }

    /**
     * 递归写法
     *
     * @param head
     * @return
     */
    public static Node getRecursion(Node head) {
        //从原链表的头结点开始
        Node cur = head;
        if (cur == null || cur.next == null) {
            return cur;
        } else {
            Node reHead = getRecursion(cur.next);
            cur.next.next = cur;
            cur.next = null;
            return reHead;
        }
    }

    public static Node getReverseUp(Node head) {
        Node pre = null;
        Node temp = null;
        while (head != null) {
            temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }


    public static Node getReverse(Node head) {
        Node pre = null;
        Node cur = head;
        Node reHead = null;
        //如果当前节点为空,结束循环
        while (cur != null) {
            //保存下一个节点，以免丢失
            Node temp = cur.next;
            //1.对pre和cur节点的关系进行反转。本来是pre指向cur的，用下面这条代码能工把cur指向pre
            cur.next = pre;
            //2.如果下一个节点为空，那他就是反转量表的头节点
            if (temp == null) {
                reHead = cur;
            }
            //3.上一节点已经反转完成了，现在移动到下一个节点了
            pre = cur;
            cur = temp;
        }
        return reHead;
    }

    public static Node getRe(Node node) {

        Stack<Node> nodeStack = new Stack<>();
        while (node != null) {
            nodeStack.push(node);
            node = node.next;
        }
        Node node1 = null;
        while (!nodeStack.isEmpty()) {
            Node pop = nodeStack.pop();
            if (node == null) {
                node = pop;
                node.next = null;
                node1 = node;
                continue;
            }
            node.next = pop;
            pop.next = null;
            node = pop;
        }
        return node1;
    }
}
