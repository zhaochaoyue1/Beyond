package com.example.student.project.domain;


import java.io.Serializable;
import java.util.Date;

/**
 * 探店表 agent_shop
 *
 * @author ruoyi
 * @date 2019-07-17
 */
public class AgentShop implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;
    /**
     * 名称
     */
    private String agentShopName;
    /**
     * 详细地址
     */
    private String address;
    /**
     * 电话
     */
    private String phone;
    /**
     * 营业开始时间
     */
    private String openTime;
    /**
     * 营业结束时间
     */
    private String  openEnd;
    /**
     * 创建人
     */
    private Long createId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改人
     */
    private Long updateId;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 经度
     */
    private String longitude;
    /**
     * 纬度
     */
    private String latitude;
    /**
     * 类型 默认是0
     */
    private Integer type;
    /**
     * 编码
     */
    private String code;
    //街道名称
    private String street;
    /**
     * 0是启用 1是禁用
     */
    private Integer status;
    private Long videoId;

    public Long getVideoId() {
        return videoId;
    }

    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }
    //    //视频名称
//    private String videoName;
//    //视频副标题
//    private String videoTitle;
//    //视频状态
//    private String videoStatus;
//    //视频所属栏目
//    private String channelName;
//    //视频作者
//    private String authorName;
//    //视频图片
//    private String videoPicLit;

//    public String getVideoPicLit() {
//        return videoPicLit;
//    }
//
//    public void setVideoPicLit(String videoPicLit) {
//        this.videoPicLit = videoPicLit;
//    }
//
//    public String getVideoName() {
//        return videoName;
//    }
//
//    public void setVideoName(String videoName) {
//        this.videoName = videoName;
//    }
//
//    public String getVideoTitle() {
//        return videoTitle;
//    }
//
//    public void setVideoTitle(String videoTitle) {
//        this.videoTitle = videoTitle;
//    }
//
//    public String getVideoStatus() {
//        return videoStatus;
//    }
//
//    public void setVideoStatus(String videoStatus) {
//        this.videoStatus = videoStatus;
//    }
//
//    public String getChannelName() {
//        return channelName;
//    }
//
//    public void setChannelName(String channelName) {
//        this.channelName = channelName;
//    }
//
//    public String getAuthorName() {
//        return authorName;
//    }
//
//    public void setAuthorName(String authorName) {
//        this.authorName = authorName;
//    }

    public String getOpenTime() {
        return openTime;
    }

    public String getOpenEnd() {
        return openEnd;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public void setOpenEnd(String openEnd) {
        this.openEnd = openEnd;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 设置：主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置：名称
     */
    public void setAgentShopName(String agentShopName) {
        this.agentShopName = agentShopName;
    }

    /**
     * 获取：名称
     */
    public String getAgentShopName() {
        return agentShopName;
    }

    /**
     * 设置：详细地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取：详细地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置：电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取：电话
     */
    public String getPhone() {
        return phone;
    }

/**
 * 设置：营业开始时间
 */

    /**
     * 设置：创建人
     */
    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    /**
     * 获取：创建人
     */
    public Long getCreateId() {
        return createId;
    }


    /**
     * 设置：修改人
     */
    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }

    /**
     * 获取：修改人
     */
    public Long getUpdateId() {
        return updateId;
    }


    /**
     * 设置：经度
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    /**
     * 获取：经度
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * 设置：纬度
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * 获取：纬度
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * 设置：类型 默认是0
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取：类型 默认是0
     */
    public Integer getType() {
        return type;
    }


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
