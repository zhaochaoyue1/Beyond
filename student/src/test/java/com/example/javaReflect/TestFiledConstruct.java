package com.example.javaReflect;

import com.alibaba.fastjson.JSONObject;

/**
 * @description: TestFiledConstruct
 * @date: 2023/3/12 下午11:46
 * @author: zcy
 * @version: 1.0
 */
public class TestFiledConstruct {
    private int age = 0;
    private String name = "zcy";

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TestFiledConstruct(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public static void main(String[] args) {
        TestFiledConstruct abc = new TestFiledConstruct(20, "abc");
        System.out.println(JSONObject.toJSONString(abc));
    }
}
