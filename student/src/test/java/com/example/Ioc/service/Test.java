package com.example.Ioc.service;

import com.example.Ioc.service.impl.ProductServiceImpl;
import com.example.Ioc.service.impl.SkuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.stream.Stream;

/**
 * @description: Test
 * @date: 2021/4/20 下午7:49
 * @author: zcy
 * @version: 1.0
 */
public class Test {
    /**
     * 基于反射复制对象
     * @param args
     */
    //@org.junit.Test
    public  void test(String[] args) {
        ProductServiceImpl productService = new ProductServiceImpl();
        SkuServiceImpl skuService = new SkuServiceImpl();
        Class<? extends ProductServiceImpl> clazz = productService.getClass();
        Field[] fields = clazz.getDeclaredFields();
        Stream.of(fields).forEach(f->{
            f.setAccessible(true);
            if(f.getType()==(SkuService.class)){
                try {
                    String name = f.getName();
                    String methodStr = "set"+name.substring(0,1).toUpperCase() + name.substring(1,name.length());
                    Method method = clazz.getMethod(methodStr, SkuService.class);
                    method.invoke(productService,skuService);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println(skuService);
        System.out.println(productService.getSkuService());
    }
    @org.junit.Test
    public void myAutowire(){
        ProductServiceImpl productService = new ProductServiceImpl();
        Class<? extends ProductServiceImpl> clazz = productService.getClass();
        Field[] declaredFields = clazz.getDeclaredFields();
        Stream.of(declaredFields).forEach(f->{

            MyAutowire annotation = f.getAnnotation(MyAutowire.class);
            if(annotation!=null){
                f.setAccessible(true);
                Class<?> type = f.getType();
                try {
                    Object o = type.newInstance();
                    f.set(productService,o);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println(productService.getSkuServiceImpl());
    }
}
