package com.example.thread.cyclicbarrier;

import java.util.concurrent.*;

/**
 * @description: CyclicBarrier
 * @date: 2022/4/9 上午10:38
 * @author: zcy
 * @version: 1.0
 */
public class CyclicBarrierPractice {
    public static void main(String[] args) throws InterruptedException {
        cyclicBarrier();
    }

    public static void cyclicBarrier()throws InterruptedException{
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
        ExecutorService pool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            final int num = i;
            Thread.sleep(1000);
            pool.execute(()->{
                System.out.println("threadNum" + num + "is ready");
                try {
                    //时间到达后直接执行，放行所有线程
                    cyclicBarrier.await(5000, TimeUnit.MILLISECONDS);
                    //cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
                System.out.println("threadNum"+num + "isFinish");
            });

        }
        pool.shutdown();
    }
}
