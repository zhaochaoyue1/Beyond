package com.example.spi;

import java.util.ServiceLoader;

/**
 * @description: Test
 * @date: 2021/12/28 下午4:45
 * @author: zcy
 * @version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        ServiceLoader<SpiInterface> load = ServiceLoader.load(SpiInterface.class);
        for(SpiInterface spiInterface:load){
            spiInterface.operation();
        }
    }
}
