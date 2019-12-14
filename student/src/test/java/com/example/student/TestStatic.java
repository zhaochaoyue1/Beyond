package com.example.student;

import com.alibaba.fastjson.JSON;

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
        //Integer a= 128;
//        Integer a = new Integer(128);
//        //Integer b=new Integer(100);
//        Integer b=128;
//        if (a==b){
//            System.out.println("正确");
//        }else{
//            System.out.println("不正确");
//        }
        //String url="https://image.ecosystemwan.com/operation/video/2019-06-20/32/a13e9e8d-96c1-4158-ac41-636135eecf37(big).jpg";
        //String s = testPic(url, 540, 960);
        School school = new School();
        school.setNextId();
        School school1 = new School();
        school1.setNextId();
        System.out.println("1:"+ school.getNextId());
        System.out.println("2:"+ school.getNextId());

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
