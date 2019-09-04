package com.example.student.project.domain;


import java.io.Serializable;
import java.util.Date;

/**
 * 视频关联商品表 video_shop
 *
 * @author ruoyi
 * @date 2019-07-16
 */
public class VideoShop implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;
    /**
     * 视频id
     */
    private Long videoId;
    /**
     * 商品id
     */
    private Integer spuId;
    /**
     * 状态 0启用 1禁用
     */
    private Integer status;
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
     * 商品名称
     */
    private String spuName;

    /**
     * 商品主图
     */
    private String masterImg;
    /**
     * 商品价格
     */
    private Double productPrice;

    /**
     * 视频名称
     */
    private String videoName;

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getMasterImg() {
        return masterImg;
    }

    public void setMasterImg(String masterImg) {
        this.masterImg = masterImg;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
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
     * 设置：视频id
     */
    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }

    /**
     * 获取：视频id
     */
    public Long getVideoId() {
        return videoId;
    }

    /**
     * 设置：商品id
     */
    public void setSpuId(Integer spuId) {
        this.spuId = spuId;
    }

    /**
     * 获取：商品id
     */
    public Integer getSpuId() {
        return spuId;
    }

    /**
     * 设置：状态 0启用 1禁用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取：状态 0启用 1禁用
     */
    public Integer getStatus() {
        return status;
    }

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
     * 设置：商品名称
     */
    public void setSpuName(String spuName) {
        this.spuName = spuName;
    }

    /**
     * 获取：商品名称
     */
    public String getSpuName() {
        return spuName;
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
