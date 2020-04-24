package com.example.student.project.dao;

import com.example.student.project.domain.Author;
import org.apache.ibatis.annotations.*;

import java.util.Date;
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

	@Insert("insert into user_rate (user_id, rate_count, create_time, update_time) values (#{userId}, #{rateCount}, #{date}, #{date}) " +
			"on duplicate key update rate_count=#{rateCount}, update_time = #{date} where ")
	@Options(useGeneratedKeys = false)
	int updateUserGender(@Param("userId") long userId, @Param("rateCount") int rateCount, @Param("date") Date date);

	@Select("select user_id > 0 from user_rate where user_id = #{userId}")
	boolean getUserIsExist(@Param("userId") Long userId);
	
}