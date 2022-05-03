package com.example.student.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @description: RequestBodyMultReaderFilter
 * @date: 2022/4/27 下午8:12
 * @author: zcy
 * @version: 1.0
 */
@Component
public class RequestBodyMultiReaderFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ServletRequest  requestWrap = null;
        if(servletRequest instanceof HttpServletRequest){
            requestWrap = new RequestBodyReaderWrapper((HttpServletRequest) servletRequest);
        }
        //获取请求中的流如何，将取出来的字符串，再次转换成流，然后把它放入到新的request对象中
        // 在chain.doFilter方法中传递新的request对象
        if(requestWrap == null){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            filterChain.doFilter(requestWrap,servletResponse);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
