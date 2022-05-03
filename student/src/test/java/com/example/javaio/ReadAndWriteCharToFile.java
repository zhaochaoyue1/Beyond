package com.example.javaio;

import java.io.*;

public class ReadAndWriteCharToFile {
    public static void main(String[] args) {
        //readAndWriteCharToFile();
        practice();
    }

    public static void practice(){
        String input = "/Users/coohua/Downloads/激活码.txt";
        String output ="/Users/coohua/Downloads/激活码3.txt";
        Reader reader = null;
        Writer writer = null;
        try {
            File file = new File(input);
            reader = new FileReader(file);
            writer = new FileWriter(output);
            char[] chars = new char[1024];
            int len = 0;
            while ((len = reader.read(chars))>0){
                writer.write(chars,0,len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    public static void readAndWriteCharToFile() {
        Reader reader = null;
        Writer writer = null;
        try {
            File readFile = new File("/Users/coohua/Downloads/激活码.txt");
            reader = new FileReader(readFile);
            File writerFile = new File("/Users/coohua/Downloads/激活码3.txt");
            writer = new FileWriter(writerFile);
            char[] chars = new char[(int) readFile.length()];
            int size = reader.read(chars);
            System.out.println("大小:" + size + "个字符;内容:" + new String(chars));
            writer.write(chars);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
