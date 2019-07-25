package com.example.student;


import lombok.extern.log4j.Log4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author:Zach
 * @Description: 定制属于自己的非阻塞线程池
 * @Date:Created in 15:26 2018/8/14
 * @Modified By:
 */

public class CustomThreadPoolExecutor {
    private static Logger log= LoggerFactory.getLogger(CustomThreadPoolExecutor.class);
    private ThreadPoolExecutor pool = null;

    /**
     * 线程池初始化方法
     *
     * corePoolSize 核心线程池大小----10
     * maximumPoolSize 最大线程池大小----30
     * keepAliveTime 线程池中超过corePoolSize数目的空闲线程最大存活时间----30+单位TimeUnit
     * TimeUnit keepAliveTime时间单位----TimeUnit.MINUTES
     * workQueue 阻塞队列----new ArrayBlockingQueue<Runnable>(10)====10容量的阻塞队列
     * threadFactory 新建线程工厂----new CustomThreadFactory()====定制的线程工厂
     * rejectedExecutionHandler 当提交任务数超过maxmumPoolSize+workQueue之和时,
     * 							即当提交第41个任务时(前面线程都没有执行完,此测试方法中用sleep(100)),
     * 						          任务会交给RejectedExecutionHandler来处理
     */

    public void init() {

        pool = new ThreadPoolExecutor(2,4,30,
                TimeUnit.MINUTES,new ArrayBlockingQueue<Runnable>(10),new CustomThreadFactory(), new CustomRejectedExecutionHandler());
    }

    public void destory() {
        if(pool !=null) {
            pool.shutdownNow();
        }
    }

    public ExecutorService getCustomThreadPoolExecutor() {
        return this.pool;
    }


    private class CustomRejectedExecutionHandler implements  RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            //记录异常
            log.error("error...................");
            /*System.out.println("error...................");*/
            BlockingQueue<Runnable> queue = executor.getQueue();
            try {
                //executor.getQueue().put(r);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //queue.add(r);
            log.info("size....................."+queue.size());
        }
    }

    private class CustomThreadFactory implements ThreadFactory {

        private AtomicInteger count = new AtomicInteger(0);

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            String threadName =  CustomThreadPoolExecutor.class.getSimpleName()+count.addAndGet(1);
            log.info(threadName);
            t.setName(threadName);
            return t;
        }
    }

    public static void main(String[] args){
        CustomThreadPoolExecutor exec = new CustomThreadPoolExecutor();

        //1. 初始化
        exec.init();

        ExecutorService pool = exec.getCustomThreadPoolExecutor();

        for(int i=0;i<101;i++) {
            log.info("提交第"+i+"个任务");
            String j=i+"";
            Future<?> submit = pool.submit(new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    log.info(">>>callable is running========"+j);
                    return null;
                }
            });
            /*pool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        log.info(">>>runnable is running========");
                        Thread.sleep(3000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            });
*/
        }

        //2. 销毁----此处不能销毁,因为任务没有提交执行完,如果销毁线程池,任务也就无法执行
        //exec.destory();

        try {
            Thread.sleep(10000);
            exec.destory();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 方法中建立一个核心线程数为30个，缓冲队列有10个的线程池。每个线程任务，执行时会先睡眠3秒，保证提交10任务时，线程数目被占用完，再提交30任务时，阻塞队列被占用完，，这样提交第41个任务是，会交给CustomRejectedExecutionHandler 异常处理类来处理。
     提交任务的代码如下：

     /*
     * Proceed in 3 steps:
     *
     * 1. If fewer than corePoolSize threads are running, try to
     * start a new thread with the given command as its first
     * task.  The call to addWorker atomically checks runState and
     * workerCount, and so prevents false alarms that would add
     * threads when it shouldn't, by returning false.
     *
     * 2. If a task can be successfully queued, then we still need
     * to double-check whether we should have added a thread
     * (because existing ones died since last checking) or that
     * the pool shut down since entry into this method. So we
     * recheck state and if necessary roll back the enqueuing if
     * stopped, or start a new thread if there are none.
     *
     * 3. If we cannot queue task, then we try to add a new
     * thread.  If it fails, we know we are shut down or saturated
     * and so reject the task.
     */
    /**
     public void execute(Runnable command) {
     if (command == null)
     throw new NullPointerException();
     int c = ctl.get();
     if (workerCountOf(c) < corePoolSize) {
     if (addWorker(command, true))
     return;
     c = ctl.get();
     }
     if (isRunning(c) && workQueue.offer(command)) {
     int recheck = ctl.get();
     if (! isRunning(recheck) && remove(command))
     reject(command);
     else if (workerCountOf(recheck) == 0)
     addWorker(null, false);
     }
     else if (!addWorker(command, false))
     reject(command);
     }
     注意：41以后提交的任务就不能正常处理了，因为，execute中提交到任务队列是用的offer方法，如上面代码，
     这个方法是非阻塞的，所以就会交给CustomRejectedExecutionHandler 来处理，
     所以对于大数据量的任务来说，这种线程池，如果不设置队列长度会OOM，设置队列长度，会有任务得不到处理，接下来我们构建一个阻塞的自定义线程池
     */
}
