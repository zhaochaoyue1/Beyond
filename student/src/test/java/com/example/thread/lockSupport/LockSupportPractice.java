package com.example.thread.lockSupport;

import java.util.concurrent.locks.LockSupport;

/**
 * @description: LockSupportPractice
 * @date: 2023/8/24 下午3:36
 * @author: zcy
 * @version: 1.0
 */
public class LockSupportPractice {
    public static void main(String[] args) {
        CarThread carThread = new CarThread();
        carThread.setName("劳斯劳斯");
        carThread.start();

        try {
            Thread.sleep(2000);
            carThread.park();
            Thread.sleep(2000);
            carThread.unPark();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

 class CarThread extends Thread{

    private boolean isStop = false;

    @Override
    public void run() {

        System.out.println(this.getName() + "正在行驶中");

        while (true) {

            if (isStop) {
                System.out.println(this.getName() + "车停下来了");
                LockSupport.park(); //挂起当前线程
            }
            System.out.println(this.getName() + "车还在正常跑");

            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void park() {
        isStop = true;
        System.out.println("停车啦，检查酒驾");

    }

    public void unPark(){
        isStop = false;
        LockSupport.unpark(this); //唤醒当前线程
        System.out.println("老哥你没酒驾，继续开吧");
    }

}
