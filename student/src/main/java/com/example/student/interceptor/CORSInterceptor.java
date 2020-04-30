package com.example.student.interceptor;

import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * http header 跨域配置
 * Created by liu liandong on 2017/7/25.
 */
public class CORSInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {

        response.addHeader("Access-Control-Allow-Origin", "*");
        //response.addHeader("Access-Control-Allow-Headers", "pkgId, wechatId, accept, ass_token, content-type,accessKey,appVersion,brand,bs,channel,content-type,deviceId,gps,os,osVersion,romVersion");
        response.addHeader("Access-Control-Request-Method", "GET, POST, PUT, DELETE, OPTIONS,OPTION");

        //对于options 请求特殊处理 直接跳过
        if(HttpMethod.OPTIONS.matches(request.getMethod())){
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {

    }
}
