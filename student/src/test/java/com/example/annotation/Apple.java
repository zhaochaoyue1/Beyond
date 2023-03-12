package com.example.annotation;

/**
 * @description: Apple
 * @date: 2021/5/28 下午5:34
 * @author: zcy
 * @version: 1.0
 */

import com.alibaba.fastjson.JSONObject;

/**
 * https://blog.csdn.net/m0_67698950/article/details/125960549
 * 使用注解
 */
public class Apple {
    @FruitName("apple")
    private String appleName;

    @FruitColor(fruitColor = FruitColor.Color.RED)
    private String appleColor;

    @FruitProvider(id=1,name = "陕西红富士集团",address = "陕西省西安市延安路")
    private String appleAddress;

    public String getAppleName() {
        return appleName;
    }

    public void setAppleName(String appleName) {
        this.appleName = appleName;
    }

    public String getAppleColor() {
        return appleColor;
    }

    public void setAppleColor(String appleColor) {
        this.appleColor = appleColor;
    }

    public String getAppleAddress() {
        return appleAddress;
    }

    public void setAppleAddress(String appleAddress) {
        this.appleAddress = appleAddress;
    }

    public void displayName(){
        System.out.println("水果的名字是： 苹果");
    }

    public static void main(String[] args) {
        Apple apple = new Apple();
        System.out.println(JSONObject.toJSONString(apple));
        apple.setAppleName("zcyApple");
        FruitInfoUtil.getFruitInfo(apple);
        System.out.println(JSONObject.toJSONString(apple));
    }
}
