package com.example.designPattern23.chainOfResponsibility.easyImpl;


/**
 * @description: SmileFilter
 * @date: 2020/6/12 下午6:25
 * @author: zcy
 * @version: 1.0
 */
public class SmileFilter implements Filter {
    @Override
    public boolean doFilter(Msg msg) {
        String msg1 = msg.getMsg();
        String replace = msg1.replace(":)", "😊");
        msg.setMsg(replace);
        return true;
    }
}
