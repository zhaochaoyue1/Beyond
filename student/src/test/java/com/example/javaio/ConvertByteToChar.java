package com.example.javaio;

import java.io.*;

public class ConvertByteToChar {
    public static void main(String[] args) {
        InputStream is = null;
        Reader reader = null;
        try {
            File file = new File("/Users/coohua/Downloads/激活码.txt");
            is = new FileInputStream(file);
            reader = new InputStreamReader(is,"UTF-8");
            char[] chars = new char[(int)file.length()];
            int read = reader.read(chars);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
