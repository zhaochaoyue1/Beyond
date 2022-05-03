package com.example.spi.impl;

import com.example.spi.SpiInterface;

/**
 * @description: SpiBImpl
 * @date: 2021/12/28 下午4:45
 * @author: zcy
 * @version: 1.0
 */
public class SpiBImpl implements SpiInterface {
    @Override
    public void operation() {
        System.out.println("我是B实现");
    }
}
