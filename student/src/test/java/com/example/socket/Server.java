package com.example.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description: Server
 * @date: 2021/1/4 下午8:54
 * @author: zcy
 * @version: 1.0
 */
public class Server {
    static {
        b=0;
    }
    static  int b;
    public static void main(String[] args) throws Exception {
        String readLine = null;
        String inTemp = null;
        String turnLine = "\n";
        final String client = "Client:";
        final String server = "Server:";

        int port = 4000;
        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket = serverSocket.accept();

        BufferedReader systemIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter socketOut = new PrintWriter(socket.getOutputStream());

        while (!"bye".equals(readLine)){
            inTemp = socketIn.readLine();
            System.out.println(client + turnLine + inTemp);
            System.out.println(server);

            readLine = systemIn.readLine();
            socketOut.println(readLine);
            socketOut.flush();
        }
        systemIn.close();
        socketIn.close();
        socketOut.close();
        socket.close();
        serverSocket.close();
    }
}
