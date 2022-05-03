package com.example.javaio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TestIO {
    public static void main(String[] args) {
        practice();
    }


    public static void practice() {
        PrintWriter pw = null;
        BufferedReader br = null;

        try {
            System.out.println("请输入:");
            pw = new PrintWriter(System.out,true);
            br = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            while ((line = br.readLine())!=null){
                if(line.equals("exit")){
                    System.exit(1);
                }
                pw.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(pw != null){
                    pw.close();
                }
                if(br != null){
                    br.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
