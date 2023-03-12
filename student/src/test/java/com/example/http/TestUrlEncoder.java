package com.example.http;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @description: TestUrlEncoder
 * @date: 2023/1/10 下午8:38
 * @author: zcy
 * @version: 1.0
 */
@Slf4j
public class TestUrlEncoder {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String encode = URLEncoder.encode("\\ X13 Max", "UTF-8");
        String enUrl = "http://127.0.0.1:8080/bubuduo-ttzyx/user/message?product=kxhy2&appId=707&eventType=25&userId=1139389973&ocpcDeviceId=4ff9f5082cc4fc9e5df385703294334b&oaid=null&model=" +
                encode +
                "&ip=27.187.236.100&sourceDeviceId=869352039449058&os=android&actionDefault=false&actionValues=1-1,2-0.647&accumulateDuration=13";

        System.out.println(enUrl);

        String key = "test";
        /*Headers.Builder builder = new Headers.Builder();
        builder.add("accessKey", "d9c59abaa09ae60949b81f1c16460336_182385");
        builder.add("appVersion","1.0.5");
        builder.add("os","android");
        Headers headers = builder.build();*/

        Request request = new Request.Builder()
                .url(enUrl)
                .get()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("accessKey", "d9c59abaa09ae60949b81f1c16460336_182385")
                .header("appVersion","1.0.5")
                .header("os","android")
                //.headers(headers)
                .build();
        //Headers build = request.headers().newBuilder().add("accessKey", "d9c59abaa09ae60949b81f1c16460336_182385").build();

        //System.out.println(JSONObject.toJSONString(build));
        try {
            Response response = getHttpClient().newCall(request).execute();
            //仅成功删除已经发送的url
            if (response.code() == 200) {
                log.info("call result, key:{},  enUrl:{}, code:{}, response:{}", key, enUrl, response.code(), response.body().string());
            }else {
                log.error("call error result, key:{},  enUrl:{}, code:{}, response:{}", key,enUrl, response.code(), response.body().string());
            }
        } catch (Exception e) {
            log.error("call error, key:{}, enUrl:{}", key, enUrl, e);
        }
    }

    private static volatile OkHttpClient okHttpClient;

    public static OkHttpClient getHttpClient(){
        if(okHttpClient == null){
            if(okHttpClient == null){
                okHttpClient = new OkHttpClient().newBuilder().build();
            }
        }
        return okHttpClient;
    }
}
