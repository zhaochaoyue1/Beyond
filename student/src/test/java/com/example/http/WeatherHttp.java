package com.example.http;

import com.alibaba.fastjson.JSONObject;
import com.example.student.util.CharacterEncodingConvert;
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
 * https://www.cnblogs.com/liyutian/p/9473747.html
 */
public class WeatherHttp {
    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final String HTTPS_UR = "https://search.cctv.com/ifsearch.php?page=1&qtext=%E5%A4%A9%E6%B0%94%E9%A2%84%E6%8A%A5&sort=date&pageSize=20&type=video&vtime=-1&datepid=3&channel=CCTV%E5%85%B6%E4%BB%96&pageflag=0&qtext_str=%E5%A4%A9%E6%B0%94%E9%A2%84%E6%8A%A5";
    private static final String VIDEO_URL = "https://vod.cntv.lxdns.com/flash/mp4video63/TMS/%s/%s/%s/%s_h264418000nero_aac32.mp4";

    /*public static void main(String[] args)throws Exception {
        Request request = new Request.Builder().url(HTTPS_UR).build();
        String string = okHttpClient.newCall(request).execute().body().string();
        Document document = Jsoup.parseBodyFragment(string);
        Element body = document.body();
        Element et = body.select(".sample_time_content").select(".image_list").select("com.example.spi.SpiInterface").get(0);
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
    }*/

    public static void main(String[] args) throws Exception {
        JSONObject jsonObject = new JSONObject();
        Request request = new Request.Builder().url(HTTPS_UR).build();
        String string = okHttpClient.newCall(request).execute().body().string();
        System.out.println(string);
        String unicodeStr = CharacterEncodingConvert.unicodeToChinese(string);
        System.out.println(unicodeStr);
        JSONObject object = JSONObject.parseObject(unicodeStr);
        JSONObject json = object.getJSONArray("list").getJSONObject(0);
        String title = json.getString("all_title");
        String[] s = title.split(" ");
        String name = s[0];
        String date = s[1];
        String year = date.substring(0, 4);
        String month = date.substring(4, 6);
        String day = date.substring(6, 8);
        String src = json.getString("imglink");
        String[] imglinks = src.split("/");
        String[] split = imglinks[imglinks.length - 1].split("-");
        String md5 = split[0];
        String videoUrl = String.format(VIDEO_URL, year, month, day, md5);
        jsonObject.put("name", name);
        jsonObject.put("src", src);
        jsonObject.put("videoUrl", videoUrl);
        jsonObject.put("date", date);
        System.out.println(JSONObject.toJSONString(jsonObject));
    }
}
