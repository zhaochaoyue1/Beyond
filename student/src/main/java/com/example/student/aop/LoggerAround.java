package com.example.student.aop;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.thymeleaf.expression.Maps;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
@Slf4j
public class LoggerAround {
    /**
     * 2. 指定切点
     * 匹配com.zdj.springboot_aop.Controller包及其子包下面的所有类的所有方法
     */
//    @Pointcut("execution(* com.example.student..*.*(..))")
//    public  void executeService(){
//
//    }
    /**
     * 环绕通知：
     *   环绕通知非常强大，可以决定目标方法是否执行，什么时候执行，
     *   执行时是否需要替换方法参数，执行完毕是否需要替换返回值。
     *   环绕通知第一个参数必须是org.aspectj.lang.ProceedingJoinPoint类型
     */
    @Around("@annotation(com.example.student.annotation.AopAnnotation)")
    public Object doAroundService(ProceedingJoinPoint pjp){
        try {
            System.out.println("日志打印");
            Object object=pjp.proceed();
            return object;
        } catch (Throwable throwable) {
            Signature signature=pjp.getSignature(); //  用的最多，通知的签名
            log.error("运行时异常：AOP 代理的名字"+signature.getDeclaringTypeName()+",代理的方法是 ："+
                    signature.getName()+",抛出异常是 ：",throwable);
        }
        return  null;
    }

    /**
     *  01 . 前置通知：方法调用前被调用
     */
    /*@Before("executeService()")
    public void doBeforeAdvice(JoinPoint joinPoint){//  通过JoinPoint 获取通知的签名信息，如目标方法名，目标方法参数信息等
        System.out.println("我是前置通知");
        Object[] obj=joinPoint.getArgs();//获取目标方法的参数信息
        joinPoint.getThis(); // AOP代理类信息
        joinPoint.getTarget(); // 代理的目标对象
        Signature signature=joinPoint.getSignature(); //  用的最多，通知的签名
        System.out.println("代理的方法是 ： "+signature.getName()); //  打印 代理的是哪一个方法
        // AOP 代理的名字
        System.out.println("AOP 代理的名字 ： "+signature.getDeclaringTypeName());
        signature.getDeclaringType();//  AOP代理类的类（class）信息

        *//*
          通过RequestContextHolder获取请求信息，如session 信息 ;
         *//*
        //  获取RequestAttributes
        RequestAttributes requestAttributes= RequestContextHolder.getRequestAttributes();
        //  从requestAttributes中获取HttpServletRequest信息
        HttpServletRequest request=(HttpServletRequest)requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        //  获取session信息
        HttpSession session=(HttpSession)requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);

        System.out.println("请求 ： "+request+" ,  HttpSession : "+session);
        Enumeration<String> enumerations=request.getParameterNames();
//        Map<String,String> parameterMaps=new HashMap<>();
        Map<String,String> parameterMaps=new HashMap<>();
        while(enumerations.hasMoreElements()){
            String parameter=enumerations.nextElement();
            parameterMaps.put(parameter,request.getParameter(parameter));
        }

//        String str=JSON.toJSONString(parameterMaps);
        String str= JSON.toJSONString(parameterMaps);//   alibaba.fastjson
        if(obj.length>0){
            System.out.println("请求参数信息为 ： "+ str );
        }

    }*/

    /**
     * 02  .后置返回通知
     * 需要注意：
     *      如果第一个参数是JoinPoint，则第二个参数是返回值的信息
     *      如果参数中的第一个不是JoinPoint，则第一个参数是returning中对应的参数，
     *    returning 限定了只有目标方法返回值与通知方法相应参数类型时才能
     * 执行后置返回通知，否则不执行;
     * 对于returning对应的通知方法参数为Object类型将匹配任何目标返回值
     * @param joinPoint
     * @param keys
     */
    /*@AfterReturning(value="execution(* com.zdj.springboot_aop.Controller..*.*(..))",returning = "keys")
    public void doAfterReturningAdvice1(JoinPoint joinPoint,Object keys){
        System.out.println("后置通知执行了！！");
        System.out.println("第一个后置返回通知的返回值是 ："+keys);
    }*/

    /*@AfterReturning(value="execution(* com.zdj.springboot_aop.Controller..*.*(..))",returning = "keys",argNames="keys")
    public void doAfterReturningAdvice2(String keys){ // 通知方法形影参数的类型是String
        System.out.println("第二个后置返回通知的返回值是 ："+keys);
    }*/

    /**
     *  03 . 后置异常通知
     *       定义一个名字，该名字用于匹配通知实现方法的一个参数名，当目标方法抛出异常返回后，将把目标方法抛出的异常传给通知方法；
     *  throwing 限定了只有目标方法抛出的异常与通知方法相应参数异常类型时才能执行后置异常通知，否则不执行，
     *      对于throwing对应的通知方法参数为Throwable类型将匹配任何异常。
     */
    /*@AfterThrowing(value="executeService()",throwing = "exception")
    public void doAfterThrowingAdvice(JoinPoint joinPoint,Throwable exception){
        // 目标方法名
        System.out.println(joinPoint.getSignature().getName());
        if(exception instanceof NullPointerException){
            System.out.println("发生了空指针异常");
        }
    }*/


    /**
     * 04 . 后置最终通知（目标方法只要执行完了就会执行后置通知方法）
     */

    /*@After("executeService()")
    public void doAfterService(JoinPoint joinPoint){
        System.out.println("后置最终通知执行了！");
    }*/



}
