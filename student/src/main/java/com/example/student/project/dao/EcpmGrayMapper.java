package com.example.student.project.dao;

import com.example.student.project.domain.EcpmGray;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EcpmGrayMapper {

    @Insert("insert ignore into ecpm_gray (`user_id`, `value`, `create_time`) values (${userId}, #{value}, now())")
    int insert(@Param("userId") long userId, @Param("value") String value);

    @Select("select user_id as userId,value  from  ecpm_gray where value like '%cmf:300000%'")
    List<EcpmGray> select();
}
