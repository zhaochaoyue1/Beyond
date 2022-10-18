package com.example.designPattern23.chainOfResponsibility.servlet;

/**
 * @description: NumServletFilter
 * @date: 2020/6/13 下午4:01
 * @author: zcy
 * @version: 1.0
 */
public class NumServletFilter implements ServletFilter {
    @Override
    public boolean doFilter(Request request, Response response, FilterChain filterChain,int index) {
        String replace = request.getStr().replace("996", "955");
        request.setStr(replace);
        response.getStr().append("startNumServletFilter--");
        filterChain.doFilterChain(request, response,index);
        String s = "endNumServletFilter--";
        response.getStr().append(s);
        return true;
    }
}
