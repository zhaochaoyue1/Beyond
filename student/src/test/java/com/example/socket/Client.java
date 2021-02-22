package com.example.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @description: Client
 * @date: 2021/1/4 下午8:46
 * @author: zcy
 * @version: 1.0
 */
public class Client {
    public static void main(String[] args) throws Exception {
        String readLine = null;
        String inTemp = null;
        String turnLine = "\n";
        final String client = "Client:";
        final String server = "Server:";
        int port = 4000;
        byte ipAddressTemp[] = {127,0,0,1};
        //byte ipAddressTemp[] = {(byte) 192, (byte) 168,100, (byte) 163};
        InetAddress ipAddress = InetAddress.getByAddress(ipAddressTemp);
        Socket socket = new Socket(ipAddress, port);
        BufferedReader systemIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter socketOut = new PrintWriter(socket.getOutputStream());

        while (!"bye".equals(readLine)){
            System.out.println(client);
            readLine = systemIn.readLine();
            socketOut.println(readLine);
            socketOut.flush();
            inTemp = socketIn.readLine();
            System.out.println(server + turnLine + inTemp);
        }
        systemIn.close();
        socketIn.close();
        socketOut.close();

    }
}
