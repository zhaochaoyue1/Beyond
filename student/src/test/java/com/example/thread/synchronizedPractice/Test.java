package com.example.thread.synchronizedPractice;

/**
 * @description: synchronized 是操作系统级别的锁，它可以锁升级（四个级别）
 * 1.new（无锁状态）
 * 2.偏向锁 当只有一个线程访问时
 * 3.轻量级锁 当有多个线程竞争时，用CAS自旋锁 （线程始终处于用户态，不用切到内核态去获取重量级锁）
 * 4.重量级锁 自旋锁过度消耗CPU升级到重量级锁，停止线程自旋，让线程进入wait
 * @date: 2020/7/11 下午9:26
 * @author: zcy
 * @version: 1.0
 */
public class Test {

    /**
     * 方法栈线程独享所以StringBuffer的synchronized的会加在test方法上，即锁粗化
     * @param str1
     * @param str2
     */
    public void test(String str1, String str2) {
        StringBuffer sb = new StringBuffer();
        sb.append(str1).append(str2);
    }

    /**
     * 锁消除 lock elimina ted
     */
    public void test(){
        StringBuffer sb = new StringBuffer();
        int i = 0;
        while (i<1000){
            sb.append(i);
            i++;
        }
    }

}
