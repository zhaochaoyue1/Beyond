package com.example.linkend;

public class SingleLinkedList {
    public int size;
    public Node head;

    public SingleLinkedList() {
        this.size = 0;
        this.head = null;
    }

    /**
     * 在头结点插入数据
     *
     * @param obj
     */
    public void addHead(Object obj) {
        Node node = new Node(obj);
        if (size == 0) {
            head = node;
        } else {
            node.next = head;
        }
        size++;
    }

    /**
     * 在尾节点插入数据
     *
     * @param obj
     */
    public void addEnd(Object obj) {
        Node node = new Node(obj);
        if (size == 0) {
            head = node;
        } else {
            Node currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = node;
        }
        size++;
    }

    /**
     * 根据下标移除节点
     *
     * @param index
     */
    public void remove(int index) {
        if (size == 0 || index > size) {
            return;
        }
        if (size == 1) {
            head = null;
            size--;
            return;
        }
        Node currentNode = head;
        Node preNode = head;
        for (int i = 0; i <= size; i++) {
            if (i == index) {
                preNode.next = currentNode.next;
                size --;
                return;
            } else {
                if (i > 0)
                    preNode = preNode.next;
                currentNode = currentNode.next;
            }
        }
    }

}
