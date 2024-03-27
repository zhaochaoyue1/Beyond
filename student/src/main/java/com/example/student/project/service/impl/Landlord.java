package com.example.student.project.service.impl;

import com.example.student.project.service.RentService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @description: Landlord
 * @date: 2021/3/11 下午4:02
 * @author: zcy
 * @version: 1.0
 */
@Service
public class Landlord implements RentService, InitializingBean{

    @PostConstruct
    public void initMethod(){
        System.out.println("spring postConstruct");
    }

    @Override
    public void rent() {
        System.out.println("房东要出租房子");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("initializingBean 的 afterPropertiesSet");
    }

    public Landlord() {
        System.out.println("自身工造方法");
    }
}
