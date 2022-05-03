package com.example.javaio;

import java.io.*;

public class ReadAndWriteByteToFile {
    public static void main(String[] args) {
        //readAndWriteByteToFile();
        practice();
    }

    public static void practice(){
        String input = "/Users/coohua/Downloads/1242x2208bb.png";
        String output ="/Users/coohua/Downloads/幸福酒厂.png";
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(input);
            os = new FileOutputStream(output);
            byte[] bytes = new byte[1024];
            int offset = 0;
            while ((offset = is.read(bytes))>0){
                os.write(bytes,0,offset);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(is != null){
                    is.close();
                }
                if(os != null){
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void readAndWriteByteToFile(){
        InputStream is =null;
        OutputStream os = null;
        try {
            is =new FileInputStream("/Users/coohua/Downloads/1284x2778bb.png");
            os = new FileOutputStream("/Users/coohua/Downloads/幸福酒厂.png");
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
