package com.example.designPattern23.chainOfResponsibility.easyImpl;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @description: ChainFilter
 * @date: 2020/6/12 下午8:41
 * @author: zcy
 * @version: 1.0
 */
public class ChainFilter implements Filter {
    Queue<Filter> list = new ArrayDeque<>();

    public ChainFilter add(Filter filter) {
        list.add(filter);
        return this;
    }

    public boolean doFilter(Msg m) {
        while(!list.isEmpty()){
            Filter poll = list.poll();
            boolean b = poll.doFilter(m);
            if(!b){
                return false;
            }
        }
        /*for (Filter f : list) {
            if (!f.doFilter(m)) {
                return false;
            }
        }*/
        return true;
    }

}
