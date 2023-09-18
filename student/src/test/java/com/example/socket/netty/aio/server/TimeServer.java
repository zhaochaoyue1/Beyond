package com.example.socket.netty.aio.server;

/**
 * @description: Timeserver
 * @date: 2023/9/15 上午10:21
 * @author: zcy
 * @version: 1.0
 */
public class TimeServer {
    public static void main(String[] args) {
        int port = 8081;
        if(args != null && args.length > 0){
            try {
                port = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                //采用默认值
            }
        }
        AsyncTimeServerHandler timeServer = new AsyncTimeServerHandler(port);
        new Thread(timeServer,"AIO-AsyncTimeServerHandler-001").start();
    }
}
