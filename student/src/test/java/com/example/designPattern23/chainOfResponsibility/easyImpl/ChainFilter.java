package com.example.designPattern23.chainOfResponsibility.easyImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: ChainFilter
 * @date: 2020/6/12 下午8:41
 * @author: zcy
 * @version: 1.0
 */
public class ChainFilter implements Filter {
    List<Filter> list = new ArrayList<>();

    public ChainFilter add(Filter filter) {
        list.add(filter);
        return this;
    }

    public boolean doFilter(Msg m) {
        for (Filter f : list) {
            if (!f.doFilter(m)) {
                return false;
            }
        }
        return true;
    }

}
