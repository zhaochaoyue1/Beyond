package com.example.designPattern23.proxy.service;

/**
 * @description: PlayGameService
 * @date: 2021/7/21 上午11:14
 * @author: zcy
 * @version: 1.0
 */
public interface PlayGameService {
    void login(String name,String password);
    void kill();
    void updateGrade();
}
