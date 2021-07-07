package com.example.jdk8;

import org.springframework.util.StopWatch;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @description: LocalDateTimePractice java8 新时间工具类 主要线程安全且内部实现更简洁
 * @date: 2020/11/4 下午2:47
 * @author: zcy
 * @version: 1.0
 * LocalDateTime用法: https://blog.csdn.net/tyjlearning/article/details/103023487
 * 类型转换：https://blog.csdn.net/u014044812/article/details/79231738
 *  ZoneId: 时区ID，用来确定Instant 和 LocalDateTime 互相转换的规则
 *  Instant: 用来表示时间线上的一个点（瞬时）
 *  LocalDate：表示没有时区的日期；不可变线程安全
 *  LocalTime：表示没有时区的时间，不可变线程安全
 *  LocalDateTime: 表示没有时区的日期时间，不可变线程安全
 *  Clock:用于访问当前时刻、日期、时间，用到时区
 *  Duration:用秒和纳秒表示时间的数量（长短），用于计算两个日期的时间间隔
 *  period:用于计算两个时间的日期间隔
 */
public class LocalDateTimePractice {
    public static void main(String[] args) {
        //secondOrMill();
        //localSwitchString();
        //duration();
        //secondOrMill();
        LocalDateTime localDateTime = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0).withNano(0);
        String yyyyMMddHHmmss = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(yyyyMMddHHmmss);
        long l = localDateTime.toEpochSecond(ZoneOffset.of("+8"));
        System.out.println(l);
    }

    private static void duration(){
        LocalDate parse = LocalDate.parse("2020-12-01", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate parse1 = LocalDate.parse("2020-12-03", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Duration duration = Duration.ofDays(0);
        long l = duration.between(parse, parse1).getSeconds();
        System.out.println(l);


    }

    private static void localSwitchString(){
        String yyyyMMddHHmmss = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        System.out.println(yyyyMMddHHmmss);
        long currentTimeMillis = System.currentTimeMillis();
        LocalDateTime localDateTime = Instant.ofEpochMilli(currentTimeMillis).atOffset(ZoneOffset.of("+8")).toLocalDateTime();
        String yyyyMMddHHmmss1 = localDateTime.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        System.out.println(yyyyMMddHHmmss1);
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
