package com.example.test;

import lombok.Data;

/**
 * @author liujinkun
 * @Title: UserInfo
 * @Description: 用户信息
 * @date 2019/8/29 8:59 PM
 */
@Data
public class UserInfo {

    // 用户id
    private Long userId;

    private String unionId;

    private String mobile;

    private String nickName;

    private String photoUrl;

    private Integer state;

    private Integer os;

    private String brand;

    private String channel;

    private String deviceId;

    private String appVersion;

    private String romVersion;

    private String osVersion;

    private Long createTime;

    private Long updateTime;

    private Integer pkgId;

    private String oaid;

    //是否受限
    private Boolean isRestricted;
    //有效好友数
    private Integer validFriendNum;
    //累计获得徒弟分红金币
    private Long prenticeBonusCountGold;
    //邀请好友数
    private Integer inviteFriendNum;
    //当前的deviceId, 上报使用
    private String curDeviceId;
}
