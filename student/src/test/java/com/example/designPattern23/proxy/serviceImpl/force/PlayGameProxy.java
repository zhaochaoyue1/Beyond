package com.example.designPattern23.proxy.serviceImpl.force;

import com.example.designPattern23.proxy.service.PlayGameService;

/**
 * @description: PlayGameProxy
 * @date: 2021/7/21 上午11:16
 * @author: zcy
 * @version: 1.0
 */
public class PlayGameProxy implements PlayGameService {
    private PlayGameService playGameService;

    public PlayGameProxy(PlayGameService playGameService){
        this.playGameService = playGameService;
    }
    @Override
    public void login(String name, String password) {
        playGameService.login(name,password);
    }

    @Override
    public void kill() {
        playGameService.kill();
    }

    @Override
    public void updateGrade() {
        playGameService.updateGrade();
    }
}
