package com.example.thread.TreadPool;

import org.assertj.core.util.Lists;

import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * @description: ThreadPoolPractice
 * 线程池的好处：
 * 1.减低资源消耗：减少线程频繁创建和销毁
 * 2.提高响应速度：当任务到达时，任务可以不要等到线程被创建就可以立即拿到线程资源
 * 3.提高线程的可管理性： 线程是稀缺资源，如果无限制的创建，不仅会消耗系统资源，还会降低系统的稳定性，
 * 使用线程池可以进行统一分配，调优和监控
 *
 *
 * <p>
 * Executor 框架是Java5之后引进的，在Java5之后，通过Executor 来启动线程比使用Thread的start方法更好，除了
 * 更容易管理，效率更好（用线程池实现，节约开销）外，还有关键的一点：有助于避免this逃逸问题。
 * 补充: this逃逸是指在构造函数返回之前其他线程就持有该对象的应用，调用尚未构造完全的对象的方法可能引发令人疑惑的错误
 * <p>
 * <p>
 * <p>
 * Executor 框架不仅包括了线程池的管理，还提供了线程工厂、队列以及拒绝策略等，Executor 框架让并发编程变得更加简单。
 *
 *
 * <p>
 * <p>
 * ThreadPoolExecutor 线程池七个参数
 * 重要的3个：
 * 1：corePoolSize :  核心线程数线程数定义了最小可以同时运行的线程数量
 * 2：maximumPoolSize: 当队列中存放的任务达到队列容量的时候，当前可以同时运行的线程数量为最大线程数。
 * 3：workQueue: 当新任务来的时候会判断当前运行的线程数量是否达到核心线程数，如果达到的话，新任务会进入队列中
 * 另外4个：
 * 4: keepAliveTime: 当线程池中的线程数量大于 corePoolSize 的时候，如果这时没有新的任务提交，核心线程外的线程
 * 不会立即销毁，而是等待，直到等待的时间超过了 keepAliveTime 才会被回收销毁。
 * 5：unit: keepAliveTime 参数的时间单位
 * 6：ThreadFactory: executor创建新线程的时候会用到
 * 7：handler: 饱和策略。关于饱和策略下面单独介绍一下
 * <p>
 * <p>
 * <p>
 * ThreadPoolExecutor 饱和策略定义：
 * 1：ThreadPoolExecutor.AbortPolicy：抛出 RejectedExecutionException来拒绝新任务的处理。默认的方法
 * 2：ThreadPoolExecutor.CallerRunsPolicy：调用执行自己的线程运行任务，也就是直接在调用execute方法的线程中运行(run)被拒绝的任务，
 * 如果执行程序已关闭，则会丢弃该任务。因此这种策略会降低对于新任务提交速度，影响程序的整体性能。
 * 如果您的应用程序可以承受此延迟并且你要求任何一个任务请求都要被执行的话，你可以选择这个策略。
 * 3：ThreadPoolExecutor.DiscardPolicy： 不处理新任务，直接丢弃掉。
 * 4：ThreadPoolExecutor.DiscardOldestPolicy： 此策略将丢弃最早的未处理的任务请求。
 *
 *
 * <p>
 * 阿里巴巴Java开发手册 中强制线程池不允许使用Executors去创建，而是通过ThreadPoolExecutor 构造函数的方式，
 * 这样的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险。
 * <p>
 * <p>
 * Executors 返回线程池对象的弊端如下：
 * FixedThreadPool 和 SingleThreadExecutor：允许请求的 队列长度为Integer.MAX_VALUE,可能堆积大量的请求，从而导致OOM.
 * CachedThreadPool 和 ScheduledThreadPool: 允许创建的线程数量为Integer.MAX_VALUE,可能会创建大量线程，从而导致OOM.
 * <p>
 * <p>
 * 常见的几个对比
 * 2.1 Runnable vs Callable
 * Runnable自Java 1.0 以来一直存在，但Callable 仅在java 1.5中引入，目的就是为了来处理Runnable不支持的用例。Runnable 接口
 * 不会返回结果和检查异常，但是Callable接口可以。所以，如果任务不需要返回结果或抛出异常推荐使用Runnable 接口，这样代码看起来会更加简洁。
 * <p>
 * 工具类 Executors 可以实现Runnable 对象和Callable对象之间的互相转换。Executors.callable(Runnable task) 或 Executors.callable(Runnable task,Object result)
 * <p>
 * 2.2 execute() vs submit()
 * execute() 方法用于提交不需要返回值的任务，所以无法判断任务是否被线程池执行成功与否
 * submit() 方法用于提交需要返回值的任务。线程池会返回一个Future类型的对象，通过这个Future 对象可以判断任务是否执行成功，
 * 并且可以通过Future 的get()方法来获取返回值，get()方法会阻塞当前线程直到任务完成，而使用get(long timeout,TimeUnit unit)方法则会阻塞当前线程一段
 * 时间后立即返回，这时候有可能任务没有执行完。
 * <p>
 *
 *
 * 2.3 shutdown() vs shutdownNow()
 * shutdown() : 关闭线程池，线程池的状态为shutdown。线程池不在接受新任务了，但是队列里的任务得执行完毕。
 * shutdownNew(): 关闭线程池，线程状态为stop。线程池会终止当前正在运行的任务，并停止处理排队的任务并返回正在等待执行的List.
 * <p>
 *
 * 2.4 isTerminated()  vs isShutdown()
 * isShutdown(): 当调用shutdown()方法后返回为true.
 * isTerminated(): 当调用shutdown() 方法后，并且所有提交的任务完成后返回true
 * <p>
 *
 * FixedThreadPool 被称为可重用固定线程池
 * 2.5
 * @date: 2020/8/7 上午11:46
 * @author: zcy
 * @version: 1.0
 */
public class ThreadPoolPractice {
    private static final int CORE_THREAD_SIZE = 5;
    private static final int MAXIMUM_THREAD_SIZE = 5;
    private static final int QUEUE_CAPACITY = 10;
    private static final Long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) {
        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(CORE_THREAD_SIZE,
                MAXIMUM_THREAD_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());
        //runnable
        //myRunnable(threadPoolExecutor);
        //Future
        future(threadPoolExecutor);

    }

    private static void future(ExecutorService threadPoolExecutor) {
        List<Future<String>> futureList = Lists.newArrayList();
        for (int i = 0; i < 100; i++) {
            MyCallable myCallable = new MyCallable();
            Future<String> submit = threadPoolExecutor.submit(myCallable);
            futureList.add(submit);
        }
        for (Future<String> f : futureList) {
            try {
                System.out.println(new Date() + "::" + f.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        //关闭线程池
        threadPoolExecutor.shutdown();
    }

    private static void myRunnable(ExecutorService threadPoolExecutor) {
        for (int i = 0; i < 10; i++) {
            //创建线程对象
            MyRunnable myRunnable = new MyRunnable(i + "");
            //执行Runnable
            threadPoolExecutor.execute(myRunnable);
        }
        //终止线程池
        threadPoolExecutor.shutdown();
        while (!threadPoolExecutor.isTerminated()) {
            //System.out.println("正在等待线程关闭");
        }
        System.out.println("Finished all treads");
    }
}


class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return Thread.currentThread().getName();
    }
}

/**
 * 这是一个简单的Runnable类，需要大约5秒钟来执行其任务
 */
class MyRunnable implements Runnable {
    private String command;

    public MyRunnable(String s) {
        this.command = s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " command " + command + " start.time = " + new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName() + " command " + command + " start.end = " + new Date());
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}
