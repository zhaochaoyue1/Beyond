package com.example.student.project.service;

import com.example.student.project.domain.EcpmGray;

import java.util.List;

/**
 * @description: EcpmService
 * @date: 2021/8/17 下午5:11
 * @author: zcy
 * @version: 1.0
 */
public interface EcpmService {
    List<EcpmGray> select();
    void delRedis();
}
