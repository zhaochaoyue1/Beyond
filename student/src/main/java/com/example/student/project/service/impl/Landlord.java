package com.example.student.project.service.impl;

import com.example.student.project.service.RentService;

/**
 * @description: Landlord
 * @date: 2021/3/11 下午4:02
 * @author: zcy
 * @version: 1.0
 */
public class Landlord implements RentService {
    @Override
    public void rent() {
        System.out.println("房东要出租房子");
    }
}
