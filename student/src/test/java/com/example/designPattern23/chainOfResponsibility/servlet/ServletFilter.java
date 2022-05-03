package com.example.designPattern23.chainOfResponsibility.servlet;

/**
 * @description: SevletFilter
 * @date: 2020/6/13 下午3:44
 * @author: zcy
 * @version: 1.0
 */
public interface ServletFilter {
    boolean doFilter(Request request,Response response,FilterChain filterChain,int index);
}
