package com.example.algorithm.linked_list;

import com.alibaba.fastjson.JSONObject;

/**
 *
 * 将链表分区
 * @description: PartitionLinked
 * @date: 2022/5/26 上午10:53
 * @author: zcy
 * @version: 1.0
 */
public class PartitionLinked {
    public static void main(String[] args) {
        Node node = Node.getNode(new int[]{1, 4, 2, 5, 32, 7, 2, 5});
        System.out.println(JSONObject.toJSONString(node));
        partition(node,5);
        System.out.println(JSONObject.toJSONString(node));
    }
    public static void partition(Node head,int num){
        Node ls = null;
        Node le = null;
        Node es = null;
        Node ee = null;
        Node gs = null;
        Node ge = null;
        while(head!=null){
            Node temp = head.next;
            head.next=null;
            if(head.value<num){
                if(ls == null){
                    ls = head;
                    le = head;

                }else{
                    le.next = head;
                    le = head;
                }
            }else if(head.value == num){
                if(es == null){
                    es = head;
                    ee = head;
                }else{
                    ee.next = head;
                    ee = head;
                }
            }else {
                if(gs == null){
                    gs = head;
                    ge = head;

                }else{
                    ge.next = head;
                    ge = head;
                }
            }
            head = temp;
        }
        if(le!=null){
            le.next = es;
            ee = ee == null ? le:ee;
        }
        if(ee != null){
            ee.next = gs;
        }
    }

    /**
     * if(ls == null){
     *             ls =es;
     *         }else{
     *             le.next=es;
     *             if(es == null){
     *                 ls=le;
     *             }else{
     *                 ls=ee;
     *             }
     *         }
     *         if(ls == null){
     *             ls = gs;
     *             ge.next=null;
     *         }else {
     *             ls.next=gs;
     *             if(gs != null){
     *                 ls.next=gs;
     *                 ge.next=null;
     *             }
     *         }
     */

}
