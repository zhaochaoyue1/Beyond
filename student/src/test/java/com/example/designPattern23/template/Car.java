package com.example.designPattern23.template;

/**
 * @description: Car
 * @date: 2020/12/18 下午5:34
 * @author: zcy
 * @version: 1.0
 */
public class Car {
    private final int id;
    private static int count = 0;

    public Car() {
        id = count++;
    }

    /**
     * 汽车底盘
     */
    private boolean chassis = false;

    /**
     * 发动机
     */
    private boolean engine = false;

    /**
     * 轮胎
     */
    private boolean wheels = false;
    /**
     * 车身
     */
    private boolean body = false;

    /**
     * 安装底盘
     */
    public void setChassis(){
        chassis = true;
    }

    /**
     * 安装发动机
     */
    public void setEngine(){
        engine = true;
    }

    /**
     * 安装轮胎
     * @return
     */
    public void setWheels(){
        wheels = true;
    }

    /**
     * 安装车身
     */
    public void setBody(){
        body = true;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", chassis=" + chassis +
                ", engine=" + engine +
                ", wheels=" + wheels +
                ", body=" + body +
                '}';
    }
}
