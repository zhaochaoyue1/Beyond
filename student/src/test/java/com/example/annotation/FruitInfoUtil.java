package com.example.annotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @description: FruitInfoUtil
 * @date: 2021/5/28 下午5:22
 * @author: zcy
 * @version: 1.0
 */
public class FruitInfoUtil {
    public static <T> void getFruitInfo(Object obj) {
        Class<?> clazz = obj.getClass();
        String strFruitName = "水果名称";
        String strFruitColor = "水果颜色";
        String strFruitProvide = "供应商";
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (field.isAnnotationPresent(FruitName.class)){
                    FruitName fruitName = field.getAnnotation(FruitName.class);
                    strFruitName = strFruitName + fruitName.value();
                    field.set(obj,strFruitName);
                    System.out.println(strFruitName);
                }else if(field.isAnnotationPresent(FruitColor.class)){
                    FruitColor fruitColor = field.getAnnotation(FruitColor.class);
                    strFruitColor = strFruitColor+fruitColor.fruitColor().toString();
                    //String name = field.getName();
                    field.set(obj,strFruitColor);
                    System.out.println(strFruitColor);
                }else if(field.isAnnotationPresent(FruitProvider.class)){
                    FruitProvider fruitProvider = field.getAnnotation(FruitProvider.class);
                    strFruitProvide = "供应商 " + fruitProvider.id() + " 供应商名称" + fruitProvider.name() + " 供应商地址：" + fruitProvider.address();
                    field.set(obj,strFruitProvide);
                    System.out.println(strFruitProvide);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

}
