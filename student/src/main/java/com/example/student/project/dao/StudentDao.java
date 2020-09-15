package com.example.student.project.dao;


import com.example.student.project.domain.Student;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  数据层
 * 
 * @author ruoyi
 * @date 2018-08-08
 */
@Repository
public interface StudentDao
{
	/**
	 * 插入
	 * @param student
	 * @return
	 */
	@Insert("insert into student (name,age) values (#{name},#{age})")
	int insert(Student student);

	/**
	 * 查询
	 * @param name
	 * @return
	 */
	@Select("select * from student where name = #{name}")
	Student getStudentByName(@Param("name") String name);

	/**
	 * 查询
	 * @param name
	 * @return
	 */
	@Select("select * from conf")
	List<Student> getConf(@Param("name") String name);

	/**
	 * 插入
	 * @param student
	 * @return
	 */
	@Insert("INSERT INTO tb_bp_config_globalconfig ( `name`, `value`, `comment`, `create_time`, `update_time`, `product`, `state`) VALUES ( #{name}, #{value}, #{comment},NOW(), NOW(), 47, 1)")
	int insertConf(Student student);

	/**
	 * 查询
	 * @param age
	 * @return
	 */
	@Select("select * from student where age = #{age}")
	Student getStudentByAge(@Param("age") Integer age);

	/**
	 * 	根据名称修改年纪
	 * @param name
	 * @param age
	 * @return
	 */
	@Update("update student set age=#{age} where name =#{name}")
	int updateByName(@Param("name")String name,@Param("age")Integer age);
	
}