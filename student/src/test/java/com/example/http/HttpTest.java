package com.example.http;

import com.alibaba.fastjson.JSONObject;
import com.example.student.project.domain.Reptile;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class HttpTest {
    private   static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final String HTTPS_URL = "https://api.caiyunapp.com/v2.5/Y1tgCUliE34Ahjj0/%s,%s/weather.json";
    private static final String HTTPS_URL_TWO = "https://www.cnblogs.com/ltl1532/%s/5882971.html";
    private static final String AiSI = "https://www.i4.cn/ring_22_0_%d.html";
    public static void main(String[] args)throws Exception{
        //getHttp();
        getHttpYinyue();
    }
    private static void getHttp()throws Exception{
        //Request request = new Request.Builder().url(String.format(HTTPS_URL,"116.329519","39.972134")).build();
        Request request = new Request.Builder().url(String.format(HTTPS_URL_TWO,"p")).build();
        String string = okHttpClient.newCall(request).execute().body().string();
        System.out.println(string);
    }
    private static void getHttpYinyue() throws IOException {
        for (int i = 0; i < 1; i++) {
            Request build = new Request.Builder().url(String.format(AiSI, i)).build();
            String string = okHttpClient.newCall(build).execute().body().string();
            Document document = Jsoup.parseBodyFragment(string);
            Element body = document.body();
            Elements attr = body.select("article").select(".ring_list");
            List<Reptile> reptiles = new ArrayList<>();
            for(Element n:attr){
                //获取标题
                String title = n.select(".title").attr("title");
                if(StringUtils.isEmpty(title)){
                    continue;
                }
                //时长
                String time = n.select(".longtime").get(0).childNodes().get(0).attr("text");
                //MP3
                String mp3 = n.select(".audio_play").attr("data-mp3");
                int m =0;
                Reptile reptile = new Reptile();
                reptile.setMp3(mp3);
                reptile.setTime(time);
                reptile.setTitle(title);
                reptiles.add(reptile);
                download(mp3,title);
            }
            System.out.println(JSONObject.toJSONString(reptiles));
            System.out.println(reptiles.size());
        }

        /*String html = "<div class='list ring_list'><p>Lorem ipsum.</p>";
        Document doc = Jsoup.parseBodyFragment(html);
        Element body = doc.body();//doc.getElementsByTag("body")
        List<Node> nodes = body.childNodes();

        System.out.println(JSONObject.toJSONString(body));*/
    }

    private static void download(String url,String name){
        InputStream in= null; //创建连接、输入流
        FileOutputStream f = null;//创建文件bai输出流
        byte [] bb=new byte[1024]; //接收缓du存
        int len;
        try {
            in = new URL(url).openConnection().getInputStream();
            f = new FileOutputStream("/Users/coohua/Downloads/aisimusic/"+name+".mp3");
            while( (len=in.read(bb))>0){ //接收
                f.write(bb, 0, len); //写入文件
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                f.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
