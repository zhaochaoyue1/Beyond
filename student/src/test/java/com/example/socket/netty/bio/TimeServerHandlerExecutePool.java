package com.example.socket.netty.bio;

import io.netty.util.concurrent.RejectedExecutionHandler;

import java.util.concurrent.*;

/**
 * @description: TimeServerHandlerExecutePool
 * @date: 2023/9/14 下午2:51
 * @author: zcy
 * @version: 1.0
 */
public class TimeServerHandlerExecutePool  {
    private  ExecutorService executorService;

    public TimeServerHandlerExecutePool(int maxPoolSize,int queueSize){
        executorService = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),maxPoolSize,
                120L, TimeUnit.SECONDS,new ArrayBlockingQueue<>(queueSize), new ThreadPoolExecutor.DiscardPolicy());
    }

    public  void execute(Runnable task){
        executorService.execute(task);
    }
}
