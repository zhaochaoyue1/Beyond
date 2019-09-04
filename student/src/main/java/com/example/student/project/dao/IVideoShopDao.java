package com.example.student.project.dao;

import com.example.student.project.domain.VideoShop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 视频关联商品 数据层
 * 
 * @author ruoyi
 * @date 2019-07-16
 */
public interface IVideoShopDao 
{

	List<VideoShop> getVideoShopByVideoId();
	
}