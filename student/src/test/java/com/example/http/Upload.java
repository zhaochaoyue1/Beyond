package com.example.http;

import okhttp3.*;

import java.io.File;
import java.io.IOException;

/**
 * @description: Upload
 * @date: 2023/10/18 下午5:26
 * @author: zcy
 * @version: 1.0
 */
public class Upload {
    /**
     * 上传资源文件
     * @param actionUrl
     * @param file
     * @param token
     * @return
     */
    public static boolean uploadFile(String actionUrl, File file, String token) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("multipart/form-data");
        RequestBody body = RequestBody.create(mediaType, file);
        Request request = new Request.Builder()
                .url(actionUrl)
                .method("POST", body)
                .addHeader("Authorization", token)
                .addHeader("Accept", "application/json;odata=verbose")
                .addHeader("Content-Type", "multipart/form-data")
                .build();
        try {
            Response response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
