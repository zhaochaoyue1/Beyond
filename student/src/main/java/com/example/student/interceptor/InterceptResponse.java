package com.example.student.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.example.student.project.domain.Student;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: InterceptResponse
 * @date: 2023/3/17 下午5:17
 * @author: zcy
 * @version: 1.0
 */
@ControllerAdvice
@Slf4j
public class InterceptResponse implements ResponseBodyAdvice<Object> {
    @Value("${system.update.id:1}")
    private long updateUserId;
    @Value("${system.update.time:123456}")
    private Long stampTime;

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        ServletServerHttpResponse responseTemp = (ServletServerHttpResponse) serverHttpResponse;
        HttpServletResponse resp = responseTemp.getServletResponse();
        ServletServerHttpRequest sshr = (ServletServerHttpRequest) serverHttpRequest;
        HttpServletRequest req = sshr.getServletRequest();
        //此处的 Result 对象是我自定义的返回值类型,具体根据自己需求修改即可
        if(body instanceof Student){
            String accKey = req.getHeader("accesskey");
            if(StringUtils.isNotEmpty(accKey)){
                String[] split = accKey.split("_");
                long userId = Long.parseLong(split[1]);
                Student result = (Student) body;
                if(userId == updateUserId){

                    log.info("打印Object：" + JSONObject.toJSONString(body));
                }
            }
        }
        log.info("打印Object：" + JSONObject.toJSONString(body));
        return body;
    }
}
