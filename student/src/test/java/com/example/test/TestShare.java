package com.example.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * @description: TestShare
 * @date: 2021/3/25 下午6:32
 * @author: zcy
 * @version: 1.0
 */
public class TestShare {
    public static void main(String[] args) throws MalformedURLException {
        String sharePool = "klcg";
        String shareUrl ="http://player.cn6sb3.top/klcg.html";
        String encode = URLEncoder.encode(shareUrl);
        String host = new URL(encode).getHost();
        String thirdDomain = "klcg.brokoko.eu";
        String replace = shareUrl.replace(host, thirdDomain);
        System.out.println(replace);
    }
}
