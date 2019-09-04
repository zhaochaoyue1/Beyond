package com.example.student.project.dao;

import com.example.student.project.domain.DataCount;

import java.util.List;

public interface DataCountDao {

    List<DataCount> getUserLikeVideoList();

    List<DataCount> getVideoLikeNum();

    List<DataCount> getVideoCommentNum();

    List<DataCount> getVideoShareNum();

    List<DataCount> getAttentionAuthorIdList();

    List<DataCount> getCollectVideoList();

    List<Long> getCookbookVideoList();

}
