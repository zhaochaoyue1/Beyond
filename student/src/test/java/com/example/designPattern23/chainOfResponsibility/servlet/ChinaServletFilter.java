package com.example.designPattern23.chainOfResponsibility.servlet;

/**
 * @description: ChinaServletFilter
 * @date: 2020/6/13 下午4:01
 * @author: zcy
 * @version: 1.0
 */
public class ChinaServletFilter implements ServletFilter {
    @Override
    public boolean doFilter(Request request, Response response, FilterChain filterChain) {
        String replace = request.getStr().replace("他妈的", "你好");
        request.setStr(replace);
        filterChain.doFilter(request, response);
        response.setStr(response.getStr() + "--ChinaServletFilter");
        return true;
    }
}
