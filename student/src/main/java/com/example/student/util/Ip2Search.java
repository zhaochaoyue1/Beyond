package com.example.student.util;

import org.apache.commons.lang3.StringUtils;
import org.lionsoul.ip2region.xdb.Searcher;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @description: Ip2Search
 * @date: 2022/9/16 上午11:54
 * @author: zcy
 * @version: 1.0
 */
public class Ip2Search {
    // 1、创建 searcher 对象
    static String dbPath = "/Users/coohua/Documents/project/Beyond/student/ip2region.xdb";
    // 1、从 dbPath 加载整个 xdb 到内存。
    static byte[] cBuff;
    static {
        try {
            cBuff = Searcher.loadContentFromFile(dbPath);
        } catch (Exception e) {
            System.out.printf("failed to load content from `%s`: %s\n", dbPath, e);
        }
    }
    public static void main(String[] args) throws IOException {

        Searcher searcher = null;
        try {
            searcher = Searcher.newWithBuffer(cBuff);
        } catch (IOException e) {
            System.out.printf("failed to create searcher with `%s`: %s\n", dbPath, e);
            return;
        }
        String ip = "14.150.59.1";
        // 2、查询
        try {

            long sTime = System.nanoTime();
            String region = searcher.search(ip);
            if(StringUtils.isNotEmpty(region)){
                String[] split = region.split("\\|");
                System.out.println(split[2]);
            }
            long cost = TimeUnit.NANOSECONDS.toMicros((long) (System.nanoTime() - sTime));
            System.out.printf("{region: %s, ioCount: %d, took: %d μs}\n", region, searcher.getIOCount(), cost);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.printf("failed to search(%s): %s\n", ip, e);
        }

        // 3、关闭资源
        searcher.close();

        // 备注：并发使用，每个线程需要创建一个独立的 searcher 对象单独使用。
    }
}
