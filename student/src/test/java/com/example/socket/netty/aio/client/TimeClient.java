package com.example.socket.netty.aio.client;

/**
 * @description: TimeClient
 * @date: 2023/9/15 下午3:36
 * @author: zcy
 * @version: 1.0
 */
public class TimeClient {
    public static void main(String[] args) {
        int port = 8081;
        if(args != null && args.length>0){
            try {
                port = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                //采用默认值
            }
        }
        new Thread(new AsyncTimeClientHandler("127.0.0.1",port),
                "AIO-AsyncTimeClientHandler").start();
    }
}
