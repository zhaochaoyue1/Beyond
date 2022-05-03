package com.example.spi.impl;

import com.example.spi.SpiInterface;

/**
 * @description: SpiImpl
 * @date: 2021/12/28 下午4:43
 * @author: zcy
 * @version: 1.0
 */
public class SpiAImpl implements SpiInterface {
    @Override
    public void operation() {
        System.out.println("我是A实现");
    }
}
