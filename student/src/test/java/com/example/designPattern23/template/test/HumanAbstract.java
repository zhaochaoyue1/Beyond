package com.example.designPattern23.template.test;

/**
 * @description: HumanAbstract
 * @date: 2021/3/12 下午4:44
 * @author: zcy
 * @version: 1.0
 */
public abstract class HumanAbstract {
    private boolean isAlarm = false;
    //启动
    void start() {}
    //发动机轰鸣
    void engineVoice(){}
    //按喇叭
    void didi(){}
    //踩油门
    void throttle(){}

    public void setAlarm(boolean alarm) {
        isAlarm = alarm;
    }

    protected  void run(){
        start();
        engineVoice();
        if(isAlarm){
            didi();
        }
        throttle();
        System.out.println("汽车启动");
    }


}
