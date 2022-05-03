package com.example.leetcode;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: Rpn
 * @date: 2021/9/11 下午8:22
 * @author: zcy
 * @version: 1.0
 */
public class Rpn {
    public static void main(String[] args) {
        String input = "21+(8-2)*2+4/2-4";
        System.out.println(getRpn2(input));
        System.out.println(calculation(getRpn2(input)));
        List<String> list = getList(input);
        System.out.println(JSONObject.toJSONString(list));
        List<String> rpn = getRpn(list);
        System.out.println(JSONObject.toJSONString(rpn));
        //结果
        System.out.println(getResult(rpn));
    }

    public static int getResult(List<String> rpn) {
        Stack<Integer> s = new Stack<>();
        for (String item : rpn) {
            switch (item) {
                case "+":
                    s.push(s.pop() + s.pop());
                    continue;
                case "-":
                    s.push(-s.pop() + s.pop());
                    continue;
                case "*":
                    s.push(s.pop() * s.pop());
                    continue;
                case "/":
                    int p1 = s.pop();
                    s.push(s.pop() / p1);
                    continue;
                default:
                    break;
            }
            s.push(Integer.valueOf(item));
        }
        return s.pop();
    }

    public static List<String> getRpn(List<String> list) {
        //运算符
        Stack<String> s1 = new Stack<>();
        //rpn
        List<String> rpn = new ArrayList<>();
        for (String item : list) {
            if (item.matches("\\d+")) {
                rpn.add(item);
            } else if ("(".equals(item)) {
                s1.push(item);
            } else if (")".equals(item)) {
                while (!s1.isEmpty() && !s1.peek().equals("(")) {
                    rpn.add(s1.pop());
                }
                s1.pop();
            } else {
                while (!s1.isEmpty() && getOption(s1.peek()) >= getOption(item)) {
                    rpn.add(s1.pop());
                }
                s1.push(item);
            }
        }
        while (!s1.isEmpty()) {
            rpn.add(s1.pop());
        }
        return rpn;
    }

    public static int calculation(List<String> list){
        Stack<Integer> stack = new Stack<>();
        for(String str:list){
            switch (str){
                case "+":
                    stack.push(stack.pop()+stack.pop());
                    break;
                case "-":
                    stack.push(-stack.pop()+stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop()*stack.pop());
                    break;
                case "/":
                    int s1= stack.pop();
                    stack.push(stack.pop()/s1);
                    break;
                default:
                    stack.push(Integer.valueOf(str));
                    break;
            }
        }
        return stack.pop();
    }

    public static List<String> getRpn2(String str) {
        char[] chars = str.toCharArray();
        int length = chars.length;
        List<String> rpn = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            char item = chars[i];
            if (item >= '0' && item <= '9') {
                String itemStr=item+"";
                while (i < length-1) {
                    char item2 = chars[i + 1];
                    if (item2 >= '0' && item2 <= '9') {
                        itemStr+=item2;
                        i++;
                    } else {
                        break;
                    }
                }
                rpn.add(itemStr);
            } else if ('(' == item) {
                stack.push(item);
            } else if (')' == item) {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    String s = stack.pop() + "";
                    rpn.add(s);
                }
                stack.pop();
            } else {
                while (!stack.isEmpty()&&getOption(stack.peek())>=getOption(item)){
                    rpn.add(stack.pop()+"");
                }
                stack.push(item);
            }
        }
        while (!stack.isEmpty()){
            rpn.add(stack.pop()+"");
        }
        return rpn;
    }

    public static int getOption(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }

    public static int getOption(String str) {
        int result = 0;
        int a = 1;
        int b = 2;
        switch (str) {
            case "+":
            case "-":
                return a;
            case "*":
            case "/":
                return b;
            default:
                return result;
        }
    }

    public static List<String> getList(String str) {
        List<String> list = new ArrayList<>();
        int i = 0;
        do {
            list.add(String.valueOf(str.charAt(i)));
            i++;
        } while (i < str.length());
        return list;
    }
}
