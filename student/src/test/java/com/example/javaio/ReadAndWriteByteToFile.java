package com.example.javaio;

import java.io.*;

public class ReadAndWriteByteToFile {
    public static void main(String[] args) {
        InputStream is =null;
        OutputStream os = null;
        try {
            is =new FileInputStream("/Users/coohua/Downloads/未命名文件.png");
            os = new FileOutputStream("/Users/coohua/Downloads/流程图.png");
            byte[] bytes = new byte[1024];
            int hasRead =0;
            while ((hasRead=is.read(bytes))>0){
                os.write(bytes,0,hasRead);
            }
            System.out.println("write success");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
