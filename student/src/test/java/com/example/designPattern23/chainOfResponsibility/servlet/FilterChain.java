package com.example.designPattern23.chainOfResponsibility.servlet;

import org.assertj.core.util.Lists;

import java.util.List;

/**
 * @description: FilterChain
 * @date: 2020/6/13 下午3:50
 * @author: zcy
 * @version: 1.0
 */
public class FilterChain {
    List<ServletFilter> filters = Lists.newArrayList();
    int index = 0;

    public FilterChain add(ServletFilter servletFilter) {
        filters.add(servletFilter);
        return this;
    }

    public boolean doFilter(Request request, Response response) {
        if (index == filters.size()) return false;
        ServletFilter servletFilter = filters.get(index);
        index++;
        return servletFilter.doFilter(request, response, this);
    }
}
