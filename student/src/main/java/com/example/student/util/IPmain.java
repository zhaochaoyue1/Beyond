package com.example.student.util;

import com.maxmind.geoip2.DatabaseReader;

import java.io.File;
import java.net.InetAddress;

/**
 * @description: IPmain
 * @date: 2022/9/16 上午10:49
 * @author: zcy
 * @version: 1.0
 */
class IPMain {

    /**
     *
     * @description: 获得国家
     * @param reader GeoLite2 数据库
     * @param ip ip地址
     * @return
     * @throws Exception
     */
    public static String getCountry(DatabaseReader reader, String ip) throws Exception {
        return reader.city(InetAddress.getByName(ip)).getCountry().getNames().get("zh-CN");
    }

    /**
     *
     * @description: 获得省份
     * @param reader GeoLite2 数据库
     * @param ip ip地址
     * @return
     * @throws Exception
     */
    public static String getProvince(DatabaseReader reader, String ip) throws Exception {
        return reader.city(InetAddress.getByName(ip)).getMostSpecificSubdivision().getNames().get("zh-CN");
    }

    /**
     *
     * @description: 获得城市
     * @param reader GeoLite2 数据库
     * @param ip ip地址
     * @return
     * @throws Exception
     */
    public static String getCity(DatabaseReader reader, String ip) throws Exception {
        return reader.city(InetAddress.getByName(ip)).getCity().getNames().get("zh-CN");
    }

    /**
     *
     * @description: 获得经度
     * @param reader GeoLite2 数据库
     * @param ip ip地址
     * @return
     * @throws Exception
     */
    public static Double getLongitude(DatabaseReader reader, String ip) throws Exception {
        return reader.city(InetAddress.getByName(ip)).getLocation().getLongitude();
    }

    /**
     *
     * @description: 获得纬度
     * @param reader GeoLite2 数据库
     * @param ip ip地址
     * @return
     * @throws Exception
     */
    public static Double getLatitude(DatabaseReader reader, String ip) throws Exception {
        return reader.city(InetAddress.getByName(ip)).getLocation().getLatitude();
    }

    public static void main(String[] args) throws Exception {
        //String path = req.getSession().getServletContext().getRealPath("/WEB-INF/classes/GeoLite2-City.mmdb");
        String path = "/Users/coohua/Downloads/GeoLite2-City.mmdb";
        // 创建 GeoLite2 数据库
        File database = new File(path);
        // 读取数据库内容
        DatabaseReader reader = new DatabaseReader.Builder(database).build();
        // 访问IP
        String ip = "223.71.15.34";
        String site = "国家："+IPMain.getCountry(reader, ip)
                + "\n省份：" + IPMain.getProvince(reader, ip)
                + "\n城市：" + IPMain.getCity(reader, ip)
                + "\n经度：" + IPMain.getLongitude(reader, ip)
                + "\n维度：" + IPMain.getLatitude(reader, ip);
        System.out.println(site);
    }

}
