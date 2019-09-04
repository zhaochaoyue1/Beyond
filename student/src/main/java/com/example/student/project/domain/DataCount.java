package com.example.student.project.domain;

import java.io.Serializable;
import java.util.List;

public class DataCount implements Serializable {
    //用户ID
    private Long userId;
    //用户喜爱的视频id集合
    private List<Long> likeVideoIds;
    //视频id
    private Long videoId;
    //视频喜爱数
    private Integer videoLikeNum;
    //视频评论数
    private Integer videoCommentNum;
    //视频分享数
    private Integer videoShareNum;
    //关注的作者id集合
    private List<Long> attentionAuthorIds;
    //用户收藏的视频集合
    private List<Long> collectVideoIds;
    //有食谱的视频集合
    private List<Long> cookbookVideoIds;

    public List<Long> getCookbookVideoIds() {
        return cookbookVideoIds;
    }

    public void setCookbookVideoIds(List<Long> cookbookVideoIds) {
        this.cookbookVideoIds = cookbookVideoIds;
    }

    public List<Long> getLikeVideoIds() {
        return likeVideoIds;
    }

    public void setLikeVideoIds(List<Long> likeVideoIds) {
        this.likeVideoIds = likeVideoIds;
    }

    public List<Long> getAttentionAuthorIds() {
        return attentionAuthorIds;
    }

    public void setAttentionAuthorIds(List<Long> attentionAuthorIds) {
        this.attentionAuthorIds = attentionAuthorIds;
    }

    public List<Long> getCollectVideoIds() {
        return collectVideoIds;
    }

    public void setCollectVideoIds(List<Long> collectVideoIds) {
        this.collectVideoIds = collectVideoIds;
    }

    public Integer getVideoCommentNum() {
        return videoCommentNum;
    }

    public void setVideoCommentNum(Integer videoCommentNum) {
        this.videoCommentNum = videoCommentNum;
    }

    public Integer getVideoShareNum() {
        return videoShareNum;
    }

    public void setVideoShareNum(Integer videoShareNum) {
        this.videoShareNum = videoShareNum;
    }

    public Long getVideoId() {
        return videoId;
    }

    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }

    public Integer getVideoLikeNum() {
        return videoLikeNum;
    }

    public void setVideoLikeNum(Integer videoLikeNum) {
        this.videoLikeNum = videoLikeNum;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


}
