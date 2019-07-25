package com.example.student.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 *
 * 方式一：通过注解扫描完成filter组件的注入
 * <filter>
 *     <filter-name></filter-name>
 *     <filter-class></filter-class>
 * </filter>
 * <filter-mapping>
 *     <filter-name></filter-name>
 *     <url-pattern></url-pattern>
 * </filter-mapping>
 * @author java
 *
 */
//@WebFilter(filterName="FirstFilter",urlPatterns={"*.do","*.jsp"})
@WebFilter(filterName="FirstFilter",urlPatterns="/firstServlet")
public class FirstFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("开始进入filter");
        chain.doFilter(request, response);
        System.out.println("离开filter");
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

}