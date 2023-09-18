package com.example.javaio;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ConvertByteToChar {
    public static void main(String[] args) {
        //convertByteToChar();
        practice();
    }

    public static void practice() {
        String dir = "/Users/coohua/Downloads/激活码.txt";
        File file = new File(dir);
        try (InputStream is = new FileInputStream(file);
             Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8)) {
            char[] arr = new char[(int) file.length()];
            int read = reader.read(arr);
            System.out.println("size: " + read + "内容: " + new String(arr));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void convertByteToChar() {
        InputStream is = null;
        Reader reader = null;
        try {
            File file = new File("/Users/coohua/Downloads/激活码.txt");
            is = new FileInputStream(file);
            reader = new InputStreamReader(is, "UTF-8");
            char[] chars = new char[(int) file.length()];
            int read = reader.read(chars);
            System.out.println("size: " + read + "\n内容: " + new String(chars));
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
