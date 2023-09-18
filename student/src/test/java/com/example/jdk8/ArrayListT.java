package com.example.jdk8;

import org.assertj.core.util.Lists;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description: ArrayListT
 * @date: 2021/8/10 下午5:07
 * @author: zcy
 * @version: 1.0
 */
public class ArrayListT {
    public static void main(String[] args) {
        List<String> list = Lists.newArrayList();
        list.add("1");
        list.add("2");
        list.add("2");
        list.add("4");
        list.add("2");

        System.out.println(list);
        list.remove("2");
        list.removeAll(Arrays.asList("2","4"));
        System.out.println(list);
        List<String> collect = list.stream().filter(o -> !o.equals("2")).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println(list.hashCode());
        list.remove("1");
        System.out.println(list);
        System.out.println(list.hashCode());
    }
}
