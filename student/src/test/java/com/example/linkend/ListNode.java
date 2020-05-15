package com.example.linkend;

public class ListNode {
    //有几条数据
    public int size = 0;
    //当前节点
    public Node head;

    public ListNode() {
        this.head = null;
    }

    /**
     * 从头结点添加
     *
     * @param o
     */
    public void addHeadNode(Object o) {
        Node node = new Node(o);
        if (size == 0) {
            head = node;
            size++;
        } else {
            node.next = head;
            head = node;
            size++;
        }
    }

    /**
     * 在末尾节点添加
     *
     * @param o
     */
    public void addEndNode(Object o) {
        Node insertNode = new Node(o);
        if (size == 0) {
            head = insertNode;
            size++;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = insertNode;
            size++;
        }
    }

    public Node get(int index) {
        if (index < 0 || index >= size) {
            System.out.println("下标越界");
            return null;
        }
        int start = 0;
        if (start == index) {
            return head;
        }
        Node temp = head;
        while (temp.next != null) {
            start++;
            temp = temp.next;
            if (start == index) {
                return temp;
            }
        }
        return null;
    }

    /**
     * 按照下标添加元素
     *
     * @param index
     * @param o
     */
    public void addIndexNode(int index, Object o) {
        if (index < 0 || index >= size) {
            System.out.println("插入位置不合法");
            return;
        }
        int start = 0;
        if (start == index) {
            addHeadNode(o);
            return;
        }
        Node insertNode = new Node(o);
        //查询插入位置的前一位
        Node prev = get(index - 1);
        insertNode.next = prev.next;
        prev.next = insertNode;
        size++;
    }

    /**
     * 删除节点
     */
    public void deleteIndexNode(int index) {
        if (index < 0 || index >= size || size == 0) {
            System.out.println("下边越界");
            return;
        }
        if (index == 0) {
            head = head.next;
            size--;
            return;
        }
        Node prev = get(index - 1);
        if (prev.next == null) {
            return;
        }
        if (prev.next.next == null) {
            return;
        }
        prev.next = prev.next.next;
        size--;
    }

    /**
     * 原地翻转
     */
    public void reverseList() {
        if (size == 0) {
            System.out.println("空链表");
            return;
        }
        if (size == 1) {
            return;
        }
        Node prev = head;
        Node pCur = head.next;
        while (pCur != null) {
            prev.next = pCur.next;
            pCur.next = head;
            head = pCur;
            pCur = prev.next;
        }
    }
}
