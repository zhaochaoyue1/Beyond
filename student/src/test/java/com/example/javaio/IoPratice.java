package com.example.javaio;

import lombok.SneakyThrows;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

/**
 * @description: IoPratice
 * @date: 2021/1/11 下午5:58
 * @author: zcy
 * @version: 1.0
 */
public class IoPratice {
    /*public static void main(String[] args) throws IOException {
        PrintWriter printWriter=null;
        BufferedReader bufferedReader =null;
        System.out.println("请输入");
        try {
            printWriter = new PrintWriter(System.out, true);
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                if(line.equals("exit")){
                    System.exit(1);
                }
                printWriter.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            printWriter.close();
            bufferedReader.close();
        }
    }*/
    /*public static void main(String[] args) throws IOException {
        InputStream is = null;
        Reader reader = null;
        File file = new File("/Users/coohua/Downloads/caf-master-c602d73b1ca6b36b1a34a0a25afd34ebff7a3485的副本.zip");
        is = new FileInputStream(file);
        reader = new InputStreamReader(is, StandardCharsets.UTF_8);
        char[] chars = new char[(int) file.length()];
        int read = reader.read(chars);
        System.out.println("大小：" + read + "\n" + "内容：\n" + new String(chars));
        reader.close();
        is.close();
    }*/

    public static void main(String[] args) throws IOException, InterruptedException {
        final PipedOutputStream outPut = new PipedOutputStream();
        final PipedInputStream input = new PipedInputStream(outPut);
        Thread thread = new Thread(() -> {
            try {
                outPut.write("hello world, pipe!\n come on ".getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    outPut.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread1 = new Thread(()->{
            try {
                int read ;
                while ((read = input.read())!=-1){
                    System.out.println("输出中");
                    System.out.print((char)read);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        TimeUnit.SECONDS.sleep(1);
        thread.start();
    }
}
