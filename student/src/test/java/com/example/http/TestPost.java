package com.example.http;

import com.alibaba.fastjson.JSONObject;
import okhttp3.*;

import java.io.IOException;

/**
 * @description: TestPost
 * @date: 2022/3/7 下午8:33
 * @author: zcy
 * @version: 1.0
 */
public class TestPost {
    private final static String PROD_HTTPS_URL = "http://url";
    public static void main(String[] args) {
        /*OkHttpClient okHttpClient = new OkHttpClient();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("param1", "p1");
        jsonObject.put("param2", "p2");
        jsonObject.put("parm3", "p3");
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody requestBody = RequestBody.create(mediaType, jsonObject.toJSONString());
        Request request = new Request.Builder().url(PROD_HTTPS_URL).method("POST", requestBody).addHeader("Content-Type", "application/json").build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            String responseStr = response.body().string();
            JSONObject json = JSONObject.parseObject(responseStr);
            System.out.println(json.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        String s= "{\"rtcode\":200,\"trace_id\":\"c8j0eabikldilcb2hdrg\",\"msg\":null,\"data\":{\"partNums\":1,\"partSize\":4194304,\"uploadID\":\"00ebd6226072a7c4bf81f86d94782db2\"}}";

    }
}
