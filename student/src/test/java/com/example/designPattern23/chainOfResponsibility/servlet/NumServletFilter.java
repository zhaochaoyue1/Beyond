package com.example.designPattern23.chainOfResponsibility.servlet;

/**
 * @description: NumServletFilter
 * @date: 2020/6/13 下午4:01
 * @author: zcy
 * @version: 1.0
 */
public class NumServletFilter implements ServletFilter {
    @Override
    public boolean doFilter(Request request, Response response, FilterChain filterChain) {
        String replace = request.getStr().replace("996", "955");
        request.setStr(replace);
        filterChain.doFilter(request, response);
        response.setStr(response.getStr() + "--NumServletFilter");
        return true;
    }
}
