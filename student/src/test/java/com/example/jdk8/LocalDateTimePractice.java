package com.example.jdk8;

import org.springframework.util.StopWatch;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * @description: LocalDateTimePractice java8 新时间工具类 主要线程安全且内部实现更简洁
 * @date: 2020/11/4 下午2:47
 * @author: zcy
 * @version: 1.0
 * LocalDateTime用法: https://blog.csdn.net/tyjlearning/article/details/103023487
 * 类型转换：https://blog.csdn.net/u014044812/article/details/79231738
 */
public class LocalDateTimePractice {
    public static void main(String[] args) {
        //secondOrMill();
        localSwitchString();
    }

    private static void localSwitchString(){
        String yyyyMMddHHmmss = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        System.out.println(yyyyMMddHHmmss);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime parse = LocalDateTime.parse(yyyyMMddHHmmss, dateTimeFormatter);
        System.out.println(parse);
    }

    /**
     * 获取毫秒和秒的方法
     * 并测试他们的性能
     * 类第一次加载需要的时间较长
     */
    private static void secondOrMill(){
        LocalDateTime now = LocalDateTime.now();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        long l = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
        stopWatch.stop();
        stopWatch.start();
        long l1 = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        stopWatch.stop();
        String s = stopWatch.prettyPrint();
        System.out.println(s);
        System.out.println(l);
        System.out.println(l1);
    }
    
}
