package com.example.student.project.domain;

import lombok.Data;

/*
关于refresh token：
为什么要刷新 access token 呢？
        一是因为 access token 是有过期时间的，到了过期时间这个 access token 就失效，需要刷新；
        二是因为一个 access token 会关联一定的用户权限，如果用户授权更改了，这个 access token 需要被刷新以关联新的权限。

为什么要专门用一个 token 去更新 access token 呢？
        如果没有 refresh token，也可以刷新 access token，但每次刷新都要用户输入登录用户名与密码，多麻烦。
        有了 refresh token，可以减少这个麻烦，客户端直接用 refresh token 去更新 access token，无需用户进行额外的操作。
*/
@Data
public class WXUserInfoData {
    // OpenID：是此网站上或应用中唯一对应用户身份的标识，网站或应用可将此ID进行存储，便于用户下次登录时辨识其身份，或将其与用户在网站上或应用中的原有账号进行绑定。
    private String openId;
    // name：用户昵称
    private String name;
    // authToken：access_token
    private String authToken;
    // authRefreshToken：是专用于刷新access token的token。
    private String authRefreshToken;
    // scope：权限
    private String scope;
    // expiresIn：access_token的过期时间
    private Integer expiresIn;
    // icon：用户头像
    private String icon;
    // gender：用户性别
    private String gender;
    // loginId：全局唯一标识
    private String loginId;
}