package com.example.socket.netty.nio;

/**
 * @description: TimeClient
 * @date: 2023/9/14 下午7:59
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
        new Thread(new TimeClientHandle("127.0.0.1",port),"TimeClient-001").start();
    }
}
