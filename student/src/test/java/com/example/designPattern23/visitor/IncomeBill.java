package com.example.designPattern23.visitor;

/**
 * @description: IncomeBill
 *  收入单子
 * @date: 2020/7/6 下午8:18
 * @author: zcy
 * @version: 1.0
 */
public class IncomeBill implements Bill {
    private double amount;
    private String item;

    public IncomeBill(double amount, String item) {
        super();
        this.amount = amount;
        this.item = item;
    }

    public IncomeBill() {
    }

    /**
     * 把改订单回调给老板或者CPA，老板做相应的操作
     * @param viewer
     */
    @Override
    public void accept(AccountBookViewer viewer) {
        viewer.viewIncomingBill(this);
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