package com.example.http;

import com.alibaba.fastjson.JSONObject;
import com.example.student.util.DateTimeUtils;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

/**
 * @description: WeatherHttp
 * @date: 2020/9/8 下午3:48
 * @author: zcy
 * @version: 1.0
 */
public class WeatherHttp {
    private   static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final String HTTPS_UR = "http://tv.cntv.cn/videoset/VSET100374596541";
    private static final String VIDEO_URL = "https://vod.cntv.lxdns.com/flash/mp4video63/TMS/%s/%s/%s/%s_h264418000nero_aac32.mp4";

    public static void main(String[] args)throws Exception {
        Request request = new Request.Builder().url(HTTPS_UR).build();
        String string = okHttpClient.newCall(request).execute().body().string();
        Document document = Jsoup.parseBodyFragment(string);
        Element body = document.body();
        Element et = body.select(".sample_time_content").select(".image_list").select("a").get(0);
        String href = et.attributes().get("href");
        String[] split = href.split("/");
        String md5 = split[3];
        Attributes attributes = et.childNodes().get(1).attributes();
        String src = attributes.get("src");
        String title = attributes.get("title");
        String[] s = title.split(" ");
        String name = s[0];
        String date = s[1];
        String year = date.substring(0, 4);
        String month = date.substring(4, 6);
        String day = date.substring(6, 8);
        String videoUrl = String.format(VIDEO_URL, year, month, day, md5);
    }
}
