package com.example.designPattern23.visitor;

/**
 * @description: Boss
 * 老板，查看账本的类之一
 * @date: 2020/7/6 下午8:21
 * @author: zcy
 * @version: 1.0
 */
public class Boss implements AccountBookViewer {
    private double totalIncome;
    private double totalConsume;

    @Override
    public void viewConsumerBill(ConsumeBill bill) {
        totalConsume += bill.getAmount();
    }

    @Override
    public void viewIncomingBill(IncomeBill bill) {
        totalIncome += bill.getAmount();
    }

    public double getTotalIncome() {
        System.out.println("老板查看一共收入多少，数目：" + totalIncome);
        return totalIncome;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public double getTotalConsume() {
        System.out.println("老板查看一共花费多少，数目：" + totalConsume);
        return totalConsume;
    }

    public void setTotalConsume(double totalConsume) {
        this.totalConsume = totalConsume;
    }
}

