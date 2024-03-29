package com.example.student;

import com.alibaba.fastjson.JSON;
import com.example.student.util.MD5Utils;
import org.apache.commons.codec.digest.DigestUtils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

public class TestStatic {
    public static void test(Integer i){
        if(i==null){
            System.out.println("--------------------------:"+1);
        }else {
            System.out.println("--------------------------:"+i);
        }
    }
    public static void main(String[] args){
//        int i = test1(1);
//        System.out.println("------------------------"+i);
        //Integer b = 128;
        //Integer com.example.spi.SpiInterface= 128;
//        Integer com.example.spi.SpiInterface = new Integer(128);
//        //Integer b=new Integer(100);
//        Integer b=128;
//        if (com.example.spi.SpiInterface==b){
//            System.out.println("正确");
//        }else{
//            System.out.println("不正确");
//        }
        //String url="https://image.ecosystemwan.com/operation/video/2019-06-20/32/a13e9e8d-96c1-4158-ac41-636135eecf37(big).jpg";
        //String s = testPic(url, 540, 960);

        /*School school = new School();
        School school1 = new School();
        System.out.println("1:"+ school.getNextId());
        System.out.println("2:"+ school.getNextId());
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Future<RunableTest>> futures = new ArrayList<>();

        Future submit = executorService.submit(new RunableTest());
        try {
            Object v = submit.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }*/
        LocalDate now = LocalDate.now(ZoneId.of("Asia/Shanghai"));
        String format = now.format(DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(format);
        String s2 = new StringBuilder().append(6510).append("oNYjDvIn$6Pp&JH3").append(1000).toString();
        System.out.println(MD5Utils.getMd5Sum(s2));
        String s = 6510+""+ 100 + "123" + 600000;
        String s1 = DigestUtils.md5Hex(s);
        System.out.println(s1);
        boolean equals = MD5Utils.getMd5Sum(s).equals(s1);
        System.out.println(equals);

    }

    private static String testPic(String oriUrl,int width,int height){
        if (oriUrl == null || !oriUrl.toLowerCase().startsWith("https:")) {
            return oriUrl;
        }
        StringBuffer result = new StringBuffer();
        result.append(oriUrl);
        result.append("@");
        result.append(String.valueOf(width));
        result.append("w_");
        result.append(String.valueOf(height));
        result.append("h_1l_2o");
        if (oriUrl.toLowerCase().endsWith(".gif")) {
            result.append(".gif");
        } else if (oriUrl.toLowerCase().endsWith(".png")) {
            result.append(".png");
        }
        return result.toString();
    }

    public static int test1(int i){
        try {
            return i;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            ++i;
            return i;
        }
    }
}
