package com.example.designPattern23.visitor;

/**
 * @description: CPA
 * 注册会计师，查看账本
 * @date: 2020/7/6 下午8:28
 * @author: zcy
 * @version: 1.0
 */
public class CPA implements AccountBookViewer {

    /**
     * 注会在看账时，如果是支出，则支出的是工资，查看是否交税了
     * @param bill
     */
    @Override
    public void viewConsumerBill(ConsumeBill bill) {
        if(bill.getItem().equals("工资")){
            System.out.println("注会查看工资是否交个人所得税");
        }
    }

    /**
     * 如果是收入，则所有的收入都要交税
     * @param bill
     */
    @Override
    public void viewIncomingBill(IncomeBill bill) {
        System.out.println("注册会计师查看收入交税了没有");
    }
}
