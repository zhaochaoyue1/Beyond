package com.example.student.project.controller;

import com.example.student.project.domain.WXUserInfoData;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Controller
@RequestMapping(value = "/CourtSystem")
public class WeiXinLoginController {

    private static final Logger logger = LoggerFactory.getLogger(WeiXinLoginController.class);

    public static final String WX_AUTH_LOGIN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token";
    public static final String WX_USERINFO_URL = "https://api.weixin.qq.com/sns/userinfo";
    //appid和appSecret 是在公众平台上申请的
    //AppId：应用唯一标识，在微信开放平台提交应用审核通过后获得
    public static final String WX_APP_ID = "wx9ecd6f7******";
    //AppSecret：应用密钥AppSecret，在微信开放平台提交应用审核通过后获得
    public static final String WX_APP_KEY = "c1bf387181aaf6e5ff********";


    /**
     * 第三方微信登录
     * @param code  客户端返回的code
     * @return
     */
    @RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
    @ResponseBody
    public WXUserInfoData checkLogin(String code) throws JSONException {
        //通过code获取access_token
        //String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code"
        StringBuffer loginUrl = new StringBuffer();
        //url拼接
        // WX_AUTH_LOGIN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token"
        //AppId：应用唯一标识，在微信开放平台提交应用审核通过后获得
        //WX_APP_ID = "wx9ecd6f7******";
        //AppSecret：应用密钥AppSecret，在微信开放平台提交应用审核通过后获得
        //WX_APP_KEY = "c1bf387181aaf6e5ff********";
        loginUrl.append(WX_AUTH_LOGIN_URL).append("?appid=")  //AppId
                .append(WX_APP_ID).append("&secret=")  //AppSecret
                .append(WX_APP_KEY).append("&code=").append(code)  //填写第二步获取的code参数
                .append("&grant_type=authorization_code");  //填authorization_code(固定，来自于官方文档)
        String loginRet = get(loginUrl.toString());
        JSONObject grantObj = new JSONObject(loginRet);
        String errcode = grantObj.optString("errcode");
        if (!StringUtils.isEmpty(errcode))
        {
            logger.error("login weixin error"+loginRet);
            return null;
        }
        String openId = grantObj.optString("openid");
        if (StringUtils.isEmpty(openId))
        {
            logger.error("login weixin getOpenId error"+loginRet);
            return null;
        }

        String accessToken = grantObj.optString("access_token");  //接口调用凭证
        String expiresIn = grantObj.optString("expires_in");  // access_token接口调用凭证超时时间，单位（秒）
        String refreshToken = grantObj.optString("refresh_token");  //用户刷新access_token
        String scope = grantObj.optString("scope");  //用户授权的作用域，使用逗号（,）分隔

        //通过access_token获取用户微信信息
        StringBuffer userUrl = new StringBuffer();
        // String url = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID";
        // 第三步获取的access_token ; OPENID:第三步获取的openId
        //WX_USERINFO_URL = "https://api.weixin.qq.com/sns/userinfo"
        userUrl.append(WX_USERINFO_URL).append("?access_token=").append(accessToken).append("&openid=").append(openId);
        String userRet = get(userUrl.toString());
        JSONObject userObj = new JSONObject(userRet);
        WXUserInfoData userInfo = new WXUserInfoData();
        userInfo.setOpenId(openId);  // 用户标识
        userInfo.setAuthToken(accessToken);
        userInfo.setAuthRefreshToken(refreshToken);  // 专用于刷新access token的token
        userInfo.setScope(scope);  //    scope：权限
        userInfo.setExpiresIn(Integer.valueOf(expiresIn));
        String nickname = userObj.optString("nickname");  // 用户昵称
        String sex = userObj.optString("sex");  // 1男，2女，0未知
        String userImg = userObj.optString("headimgurl");  //头像链接
        String unionid = userObj.optString("unionid");  //全局唯一标识
        userInfo.setName(nickname);
        userInfo.setIcon(userImg);
        userInfo.setGender(sex);
        userInfo.setLoginId(unionid);
        return userInfo;
    }


    public static String get(String url) {
        String body = null;
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            logger.info("create httppost:" + url);
            HttpGet get = new HttpGet(url);
            get.addHeader("Accept-Charset","utf-8");
            HttpResponse response = sendRequest(httpClient, get);
            body = parseResponse(response);
        } catch (IOException e) {
            logger.error("send post request failed: {}", e.getMessage());
        }

        return body;
    }

    private static String paramsToString(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        try{
            for (String key : params.keySet()) {
                sb.append(String.format("&%s=%s", key, URLEncoder.encode(params.get(key), StandardCharsets.UTF_8.toString())));
            }
        }catch(UnsupportedEncodingException e){
            logger.warn("{}: encode url parameters failed", e.getMessage());
        }
        return sb.length() > 0 ? "?".concat(sb.substring(1)) : "";
    }

    private static HttpResponse sendRequest(CloseableHttpClient httpclient, HttpUriRequest httpost)
            throws ClientProtocolException, IOException {
        HttpResponse response = null;
        response = httpclient.execute(httpost);
        return response;
    }

    private static String parseResponse(HttpResponse response) {
        logger.info("get response from http server..");
        HttpEntity entity = response.getEntity();

        logger.info("response status: " + response.getStatusLine());
        Charset charset = ContentType.getOrDefault(entity).getCharset();
        if (charset != null) {
            logger.info(charset.name());
        }

        String body = null;
        try {
            body = EntityUtils.toString(entity, "utf-8");
            logger.info("body " + body);
        } catch (IOException e) {
            logger.warn("{}: cannot parse the entity", e.getMessage());
        }

        return body;
    }


}