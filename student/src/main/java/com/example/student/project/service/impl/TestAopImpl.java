package com.example.student.project.service.impl;

import com.example.student.annotation.AopAnnotation;
import com.example.student.project.service.TestAop;
import org.springframework.stereotype.Service;

/**
 * @description: TestAopImpl
 * @date: 2022/12/23 下午4:04
 * @author: zcy
 * @version: 1.0
 */
@Service
public class TestAopImpl implements TestAop {


    @Override
    @AopAnnotation
    public int test1() {
        System.out.println("输出test1");
        return 0;
    }

    @Override
    @AopAnnotation
    public void test2() {
        System.out.println("输出test2");
    }

    @Override
    public void test3() {
        System.out.println("输出test3");
    }
}
