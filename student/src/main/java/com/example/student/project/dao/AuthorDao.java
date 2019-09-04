package com.example.student.project.dao;

import com.example.student.project.domain.Author;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 *  数据层
 * 
 * @author ruoyi
 * @date 2018-08-08
 */
public interface AuthorDao
{

	List<Author> getAuthorList();
	
}