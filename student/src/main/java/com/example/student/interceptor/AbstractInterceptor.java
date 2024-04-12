package com.example.student.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.example.student.enumEntity.ResponseEnum;
import com.example.student.project.domain.WebMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@Slf4j
public abstract class AbstractInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        ResponseEnum result ;
        try {
            result =preFilter(request);
        } catch (Exception e) {
            log.info("preFilter catch an Exception: ",e);
            result = ResponseEnum.SERVER_ERROR;
        }

        if(ResponseEnum.OK == result){
            return true;
        }
        handleResponse(result,response);
        return false;
    }

    protected abstract ResponseEnum preFilter(HttpServletRequest request);

    //处理失败返回结果
    private void handleResponse(ResponseEnum result,HttpServletResponse response){
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        try(PrintWriter writer = response.getWriter()) {
            writer.write(JSONObject.toJSONString(WebMessage.build(result.getCode(),result.getMsg())));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
