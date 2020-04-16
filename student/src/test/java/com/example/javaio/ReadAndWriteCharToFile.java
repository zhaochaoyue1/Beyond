package com.example.javaio;

import java.io.*;

public class ReadAndWriteCharToFile {
    public static void main(String[] args) {
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
