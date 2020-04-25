package com.example.http;

import okhttp3.OkHttpClient;
import okhttp3.Request;


public class HttpTest {
    private   static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final String HTTPS_URL = "https://api.caiyunapp.com/v2.5/Y1tgCUliE34Ahjj0/%s,%s/weather.json";
    private static final String HTTPS_URL_TWO = "https://www.cnblogs.com/ltl1532/%s/5882971.html";
    public static void main(String[] args)throws Exception{
        getHttp();

    }
    private static void getHttp()throws Exception{
        //Request request = new Request.Builder().url(String.format(HTTPS_URL,"116.329519","39.972134")).build();
        Request request = new Request.Builder().url(String.format(HTTPS_URL_TWO,"p")).build();
        String string = okHttpClient.newCall(request).execute().body().string();
        System.out.println(string);
    }
}
