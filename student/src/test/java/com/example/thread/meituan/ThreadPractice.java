package com.example.thread.meituan;

import com.alibaba.fastjson.parser.Feature;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * https://zhuanlan.zhihu.com/p/123328822
 *
 * @description: ThreadPractice
 * @date: 2021/3/25 上午11:29
 * @author: zcy
 * @version: 1.0
 */
@Slf4j
public class ThreadPractice {
    public static void main(String[] args) throws Exception {
        arrayBlockQueue();
        //synchronousQueue();
    }

    /**
     * 一个数组实现的有限阻塞队列，此队列按照先进先出（FIFO)的原则对元数据进行排序，支持公平和非公平锁
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void arrayBlockQueue() throws ExecutionException, InterruptedException {
        ThreadFactory build = new ThreadFactoryBuilder().setNameFormat("arrayBlockQueue-pool-%d").build();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 5, 1, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10), build, new ThreadPoolExecutor.AbortPolicy());
        int corePoolSize = threadPoolExecutor.getCorePoolSize();
        List<Future> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            int finalI = i;
            //submit时就开始执行了
            Future<?> submit = threadPoolExecutor.submit(() -> {
                log.info(finalI + "");
            });
            list.add(submit);
        }
        System.out.println("开始遍历");
        for (Future future : list) {
            future.get();
        }
    }

    /**
     * 一个由链表结构组成的有界队列，此队列按照先进先出的原则对元素进行排序。此队列的默认长度为Integer.MAX_VALUE,
     * 所以默认创建的该队列有容量危险
     */
    public static void linkedBlockQueue() {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("linkedBlockQueue-pool-%d").build();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5, 1, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(), threadFactory, new ThreadPoolExecutor.AbortPolicy());

    }

    /**
     * 一个支持线程优先级排序的无界队列，默认自然顺序进行排序，也可以自定义实现compareTo()方法来指定元素排序规则，
     * 不能保证同优先级元素的顺序
     * 无界队列：有内存问题
     */
    public static void priorityBlockingQueue() {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("priorityBlockingQueue-pool-%d").build();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5, 1, TimeUnit.SECONDS,
                new PriorityBlockingQueue<>(), threadFactory, new ThreadPoolExecutor.AbortPolicy());
    }

    /**
     * 一个实现PriorityBlockingQueue实现延迟获取的无界队列，在创建元素时，可以指定多久才能从队列中获取当前元素。
     * 只有延时期满才能从队列中获取元素
     */
    public static void DelayQueue() {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("delayQueue-pool-%d").build();
        ///new ThreadPoolExecutor(2, 5, 1, TimeUnit.SECONDS,new DelayQueue<>(), threadFactory, new ThreadPoolExecutor.AbortPolicy());
    }

    /**
     * 一个不存储元素的阻塞队列，每一个put操作必须等待take操作，否则不能添加元素。支持公平锁和非公平锁。
     * SynchronousQueue的一个使用场景是在线程池里。Executors.newCachedThreadPool()就使用了SynchronousQueue
     * ,这个线程池根据需要创建新的线程，如果有空闲线程则会重复使用，线程空闲了6oS就会被回收
     * @throws InterruptedException
     */
    public static void synchronousQueue() throws InterruptedException {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("synchronousQueue-pool-%d").build();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 10, 60, TimeUnit.SECONDS, new SynchronousQueue<>(),
                threadFactory, new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 10; i++) {
            final int finalI = i;
            try {
                threadPoolExecutor.execute(()->{
                    log.info(finalI+"");
                });
            } catch (Exception e) {
                e.printStackTrace();
                i--;
                TimeUnit.SECONDS.sleep(1);
            }
        }
    }

    /**
     * LinkedBlockingDeque : 一个由链表结构组成的双向阻塞队列。队列头部和尾部都可以添加和移除元素，多线程并发时，可以将锁的竞争最多降到一半
     */

}
