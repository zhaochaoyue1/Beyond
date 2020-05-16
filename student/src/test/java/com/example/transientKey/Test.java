package com.example.transientKey;

import com.alibaba.fastjson.JSONObject;

public class Test {
    public static void main(String[] args) {
        /**
         * transient关键字将不需要的字段，用transient修饰；序列化时对象这个字段就不会被序列化，序列化的对象需要实现序列化接口
         *  transient 底层实现原理
         *     java的serializable提供了一个非常棒的存储对象状态的机制，说白了serializable就是把对象的状态存储到硬盘上去，
         *  等需要的时候就可以把它读出来使用。有些时候想银行卡号这些字段是不希望在网络传输的，transient的作用就是把这个字段的
         *  生命周期仅存在于调用者的内存中而不会写到磁盘里持久化，意思是transient修饰的name字段，他的生命周期仅仅在内存中，不会
         *  被写到磁盘中。
         */
        Book build = Book.builder().id(1).name("zcy").title("title").build();
        System.out.println(JSONObject.toJSONString(build));
        String name = build.getName();
        System.out.println(name);
    }
}
