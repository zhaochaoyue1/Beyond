package com.example.designPattern23.template;

/**
 * @description: Robot
 * @date: 2020/12/18 下午6:03
 * @author: zcy
 * @version: 1.0
 */
public abstract class Robot {
    protected Assembler assembler;

    public void setAssembler(Assembler assembler){
        this.assembler = assembler;
    }

    protected void assembler(){
        System.out.println("开始装配：" + assembler.car);
        performance();
        System.out.println("装配完成：" + assembler.car);
    }

    protected abstract void performance();
}
