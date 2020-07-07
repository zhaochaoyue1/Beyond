package com.example.designPattern23.visitor;

/**
 * @description: ConsumeBill
 * 消费单子
 * @date: 2020/7/6 下午8:14
 * @author: zcy
 * @version: 1.0
 */
public class ConsumeBill implements Bill {
    private double amount;
    private String item;

    /**
     * 把改订单回调给老板或者CPA，老板做相应的操作
     * @param viewer
     */
    @Override
    public void accept(AccountBookViewer viewer) {
        viewer.viewConsumerBill(this);
    }

    public ConsumeBill() {
    }

    public ConsumeBill(double amount, String item) {
        super();
        this.amount = amount;
        this.item = item;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
