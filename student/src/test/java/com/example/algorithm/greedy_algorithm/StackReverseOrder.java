package com.example.algorithm.greedy_algorithm;

import com.alibaba.fastjson.JSONObject;

import java.util.Stack;

/**
 * 栈逆序
 * @description: StackReverseOrder
 * @date: 2022/6/1 下午4:19
 * @author: zcy
 * @version: 1.0
 */
public class StackReverseOrder {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(JSONObject.toJSONString(stack));
        reStack2(stack);
        System.out.println(JSONObject.toJSONString(stack));
    }

    public static void reStack(Stack<Integer> stack){
        if(stack.size() == 0){
            return;
        }
        int low = stackLow(stack);
        reStack(stack);
        stack.push(low);
    }

    public static int stackLow(Stack<Integer> stack){
        if(stack.size() == 1){
            return stack.pop();
        }
        Integer pop = stack.pop();
        int i = stackLow(stack);
        stack.push(pop);
        return i;
    }

    public static  void reStack2(Stack<Integer> stack){
        if(stack.size() == 0){
            return;
        }
        int min = min(stack);
        reStack2(stack);
        stack.push(min);
    }

    public static int min(Stack<Integer> stack){
        if(stack.size() == 1){
            return stack.pop();
        }
        Integer pop = stack.pop();
        int min = min(stack);
        stack.push(pop);
        return min;
    }

}
