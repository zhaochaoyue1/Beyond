package com.example.jdk8.innerclass;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * @description: TestStaticInnerClass
 * @date: 2022/1/7 下午2:38
 * @author: zcy
 * @version: 1.0
 */
public class TestStaticInnerClass {
    private int a;
    private int b;
    @Data
    static class StaticInner{
        private int a;
        private int b;
        public StaticInner(int a,int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) {
        StaticInner staticInner = new StaticInner(1, 2);
        StaticInner staticInner1 = new StaticInner(3, 4);
        System.out.println(JSONObject.toJSONString(staticInner));
        System.out.println(JSONObject.toJSONString(staticInner1));
    }

}
