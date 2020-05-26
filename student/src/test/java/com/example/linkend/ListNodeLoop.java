package com.example.linkend;

import com.alibaba.fastjson.JSONObject;

import java.util.HashSet;

/**
 * description: 单向链表是否有循环
 * 学习：https://blog.csdn.net/u010983881/article/details/78896293
 * date: 2020/5/26 下午3:12
 * author: zcy
 * version: 1.0
 */
public class ListNodeLoop {
    public static void main(String[] args) {
        Node node = getListNode();
        System.out.println(JSONObject.toJSONString(node));
        //set集合判断是否是闭环
        boolean isLoop = getIsLoop(node);
        System.out.println(isLoop);
        //快慢指针判断是否是闭环
        boolean loop = isLoop(node);
        System.out.println(loop);
        //set集合返回入口点
        Node nodeSet = getNodeSet(node);
        System.out.println(nodeSet.data);
        //根据快慢指针获取返回入口点
        Node nodePoint = getNodePoint(node);
        System.out.println(nodePoint.data);
    }

    /**
     * description: 快慢指针获取环的入口点
     * date: 2020/5/26 下午6:02
     * author: zcy
     *
     * @param node
     * @return version: 1.0
     */
    private static Node getNodePoint(Node node) {
        Node fast = node, slow = node;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                break;
            }
        }
        //没有环返回null
        if (slow == null || fast.next == null) {
            return null;
        }
        fast = node;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * set判断是否是循环链表
     *
     * @param node
     * @return
     */
    private static Node getNodeSet(Node node) {
        if (node == null) {
            return null;
        }
        HashSet<Integer> nodes = new HashSet<>();
        nodes.add(System.identityHashCode(node));
        Node p = node;
        while (p.next != null) {
            p = p.next;
            int size = nodes.size();
            nodes.add(System.identityHashCode(p));
            int size1 = nodes.size();
            if (size == size1) {
                return p;
            }
        }
        return null;
    }

    //快慢指针判断该链表是否是闭环的
    public static boolean isLoop(Node node) {
        if (node == null) {
            return false;
        }
        //慢指针，一次移动一位
        Node p1 = node;
        //快指针，一次移动两位
        Node p2 = node;
        while (p1 != null && p2 != null) {
            p2 = p2.next;
            if (p2 == null) {
                return false;
            }
            p2 = p2.next;
            if (p2 == null) {
                return false;
            }
            p1 = p1.next;
            if (p1 == p2) {
                return true;
            }
        }
        return false;
    }

    /**
     * set判断是否是循环链表
     *
     * @param node
     * @return
     */
    private static boolean getIsLoop(Node node) {
        if (node == null) {
            return false;
        }
        HashSet<Integer> nodes = new HashSet<>();
        nodes.add(System.identityHashCode(node));
        Node p = node;
        while (p.next != null) {
            p = p.next;
            int size = nodes.size();
            nodes.add(System.identityHashCode(p));
            int size1 = nodes.size();
            if (size == size1) {
                return true;
            }
        }
        return false;
    }

    /**
     * description:  获取一个闭环链表
     * date: 2020/5/26 下午3:50
     * author: zcy
     *
     * @param
     * @return version: 1.0
     */
    public static Node getListNode() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node1;
        return node1;
    }
}
