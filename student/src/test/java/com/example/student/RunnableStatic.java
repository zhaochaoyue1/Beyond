package com.example.student;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableStatic {
    boolean flag = false;
    CyclicBarrier cyclicBarrier = new CyclicBarrier(10);

    private void runThread() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executorService.execute(createThread(i));
        }
    }
    private Thread createThread(int i){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cyclicBarrier.await();
                    School school = new School();
                    System.out.println("i" + school.getNextId());
                    System.out.println("j" + school.getVolatileId());
                    System.out.println("Thread:" + Thread.currentThread().getName() + "准备完毕,time:" + System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

            }
        });
        thread.setName("name"+i);
        return thread;
    }

    public static void main(String[] args) throws Exception {
        RunnableStatic runnableStatic = new RunnableStatic();
        runnableStatic.runThread();
        Thread.sleep(2000);
        School school = new School();
        System.out.println("测试------"+school.getVolatileId() + "      "+school.getNextId());
    }
}
