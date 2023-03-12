package com.example.student.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @description: AopAdvice
 * @date: 2022/12/23 下午3:55
 * @author: zcy
 * @version: 1.0
 */
@Component
@Aspect
public class AopAdvice {

    @Pointcut("@annotation(com.example.student.annotation.AopAnnotation)")
    public void pointCut(){

    }

    @Around("pointCut()")
    public Object advice(ProceedingJoinPoint pjp) throws Throwable {
        try {
            System.out.println("增强过");
            return pjp.proceed();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
