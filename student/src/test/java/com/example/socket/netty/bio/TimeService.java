package com.example.socket.netty.bio;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * @description: TimeService
 * @date: 2023/9/13 下午8:25
 * @author: zcy
 * @version: 1.0
 */
public class TimeService {
    public static void main(String[] args) {
        int port = 8081;
        if(args != null && args.length > 0){
            try {
                port = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                //采用默认值
            }
        }
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("this time server is start in port : " + port);
            TimeServerHandlerExecutePool executePool = new TimeServerHandlerExecutePool(50, 100);
            Socket socket = null;
            while(true){
                socket = server.accept();
                executePool.execute(new TimeServerHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(server != null){
                System.out.println("The time server close");
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                server = null;
            }
        }
    }
}

class TimeServerHandler implements  Runnable{
    private Socket socket;

    public TimeServerHandler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader in = null;
        PrintWriter out = null;
        try{
            in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            out = new PrintWriter(this.socket.getOutputStream(),true);
            String currentTime = null;
            String body = null;
            while (true){
                body = in.readLine();
                if(body == null){
                    break;
                }
                System.out.println("this time server receive order : " + body);
                currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString(): "BAD ORDER";
                out.println(currentTime);
            }
        }catch (Exception e){
            if(in != null){
                try {
                    in.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            if(out != null){
                try {
                    out.close();
                    out = null;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            if(this.socket != null){
                try {
                    this.socket.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                this.socket = null;
            }
        }
    }
}
