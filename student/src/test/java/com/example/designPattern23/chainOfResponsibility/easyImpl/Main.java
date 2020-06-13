package com.example.designPattern23.chainOfResponsibility.easyImpl;

import com.alibaba.fastjson.JSONObject;

/**
 * @description: Main
 * @date: 2020/6/11 下午9:16
 * @author: zcy
 * @version: 1.0
 */
public class Main {

    public static void main(String[] args) {
        Msg msg = new Msg();
        String m = "123,:),他妈的,难过，中不中";
        msg.setMsg(m);
        ChainFilter list = new ChainFilter();
        list.add(new NumFilter())
                .add(new ChinaFilter())
                .add(new SmileFilter());

        ChainFilter list2 = new ChainFilter();
        list2.add(new MoodFilter()).add(new ProvincialismFilter());
        list.add(list2);
        list.doFilter(msg);

        System.out.println(JSONObject.toJSONString(msg));
    }
}
