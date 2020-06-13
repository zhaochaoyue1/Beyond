package com.example.designPattern23.chainOfResponsibility.easyImpl;

/**
 * @description: NumFilter
 * @date: 2020/6/12 下午6:21
 * @author: zcy
 * @version: 1.0
 */
public class NumFilter implements Filter {
    @Override
    public boolean doFilter(Msg msg) {
        String msg1 = msg.getMsg();
        String num = msg1.replace("123", "num");
        msg.setMsg(num);
        return true;
    }
}
