package com.example.designPattern23.visitor;

/**
 * @description: Bill 单个单子的接口
 * @date: 2020/7/6 下午7:59
 * @author: zcy
 * @version: 1.0
 */
public interface Bill {
    void accept(AccountBookViewer viewer);
}
