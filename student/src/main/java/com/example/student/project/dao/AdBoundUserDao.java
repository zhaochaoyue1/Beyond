package com.example.student.project.dao;

import com.example.student.project.domain.Author;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 *  数据层
 * 
 * @author ruoyi
 * @date 2018-08-08
 */
public interface AdBoundUserDao
{
	@Update("update app_bound_user set timeStr = #{timeStr} where id =#{id}")
	int update(@Param("id")Integer id,@Param("timeStr")String timeStr);
	
}