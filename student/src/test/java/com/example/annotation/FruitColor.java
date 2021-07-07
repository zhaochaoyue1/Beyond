package com.example.annotation;

import java.lang.annotation.*;

/**
 * @description: FruitColor
 * @date: 2021/5/28 下午4:09
 * @author: zcy
 * @version: 1.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FruitColor {
    /**
     * 颜色枚举
     */
    public enum Color{BLUE,RED,GREEN};

    /**
     * 颜色属性
     */
    Color fruitColor() default  Color.GREEN;
}
