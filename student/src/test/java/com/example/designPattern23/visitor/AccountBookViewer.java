package com.example.designPattern23.visitor;

/**
 * @description: AccountBookViewer
 * 账单查看者接口(相当于Visitor)
 * @date: 2020/7/6 下午8:06
 * @author: zcy
 * @version: 1.0
 */
public interface AccountBookViewer {
    /**
     * 查看消费的单子
     * @param bill
     */
    void viewConsumerBill(ConsumeBill bill);

    /**
     * 查看消费单子
     * @param bill
     */
    void viewIncomingBill(IncomeBill bill);
}
