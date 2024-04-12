package com.example.student.interceptor;

import com.example.student.enumEntity.ResponseEnum;
import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Component
public class RateLimitInterceptor extends  AbstractInterceptor{

    /**
     * 单机全局限流器
     */
    private static final RateLimiter  rateLimiter =  RateLimiter.create(1);
    @Override
    protected ResponseEnum preFilter(HttpServletRequest request) {
        if(!rateLimiter.tryAcquire()){
            log.info("限流中......");
            return ResponseEnum.RATE_LIMIT;
        }
        log.info("请求成功");
        return ResponseEnum.OK;
    }
}
