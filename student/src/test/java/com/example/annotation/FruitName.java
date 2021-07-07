package com.example.annotation;

import java.lang.annotation.*;

/**
 * @description: FruitName
 * @date: 2021/5/28 下午4:04
 * @author: zcy
 * @version: 1.0
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FruitName {
    String value() default "";
}
