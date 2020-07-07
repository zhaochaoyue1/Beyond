package com.example.designPattern23.visitor;

import org.assertj.core.util.Lists;

import java.util.List;

/**
 * @description: AccountBook
 * 账本类
 * @date: 2020/7/6 下午8:34
 * @author: zcy
 * @version: 1.0
 */
public class AccountBook {
    //单子列表
    private List<Bill> bills = Lists.newArrayList();

    /**
     * 添加单子
     *
     * @param bill
     */
    public void addBill(Bill bill) {
        bills.add(bill);
    }

    /**
     * 供账本的查看者查看
     *
     * @param viewer
     */
    public void show(AccountBookViewer viewer) {
        for (Bill bill : bills) {
            bill.accept(viewer);
        }
    }
}
