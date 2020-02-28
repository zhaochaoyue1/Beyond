package com.example.student.project.dao;


import io.lettuce.core.dynamic.annotation.Param;

/**
 *  数据层
 * 
 * @author ruoyi
 * @date 2018-08-08
 */
public interface CaladerDao
{
	int saveCalender(@Param("id")String id, @Param("text")String text,@Param("timeStamp")Long timeStamp);

	String getCalendar(@Param("id")String id);
	
}