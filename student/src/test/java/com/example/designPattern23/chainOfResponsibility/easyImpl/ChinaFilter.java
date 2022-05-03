package com.example.designPattern23.chainOfResponsibility.easyImpl;

/**
 * @description: ChinaFilter
 * @date: 2020/6/12 下午6:23
 * @author: zcy
 * @version: 1.0
 */
public class ChinaFilter implements Filter {
    @Override
    public boolean doFilter(Msg msg) {
        String msg1 = msg.getMsg();
        /*if(msg1.contains("他妈的")){
            return false;
        }*/
        String replace = msg1.replace("他妈的", "你好");
        msg.setMsg(replace);
        return true;
    }
}
