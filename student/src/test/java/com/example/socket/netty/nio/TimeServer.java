package com.example.socket.netty.nio;

/**
 * @description: TimeServer
 * @date: 2023/9/14 下午5:12
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
        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port,1024);
        new Thread(timeServer,"NIO-MultiplexerTimeServer-001").start();
    }
}
