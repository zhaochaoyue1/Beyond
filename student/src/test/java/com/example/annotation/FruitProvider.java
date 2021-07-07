package com.example.annotation;

import java.lang.annotation.*;

/**
 * @description: FruitProvider
 * @date: 2021/5/28 下午5:00
 * @author: zcy
 * @version: 1.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider {
    /**
     * 供应商编号
     */
    public int id() default -1;

    /**
     * 供应商名称
     */
    public String name() default "";

    /**
     * 供应商地址
     */
    public String address() default "";

}
