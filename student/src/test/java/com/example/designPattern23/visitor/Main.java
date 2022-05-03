package com.example.designPattern23.visitor;

/**
 * @description: Main
 * @date: 2020/7/6 下午8:37
 * @author: zcy
 * @version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        AccountBook accountBook = new AccountBook();
        accountBook.addBill(new IncomeBill(100,"卖商品"));
        accountBook.addBill(new IncomeBill(200,"卖广告"));

        accountBook.addBill(new ConsumeBill(10,"工资"));
        accountBook.addBill(new ConsumeBill(20,"材料费"));
        Boss boss = new Boss();
        CPA cpa = new CPA();

        accountBook.show(boss);
        accountBook.show(cpa);

        boss.getTotalConsume();
    }
}
