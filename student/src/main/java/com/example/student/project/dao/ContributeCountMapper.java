package com.example.student.project.dao;


import com.example.student.project.domain.ContributeCountEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContributeCountMapper {
    @Select("SELECT user_id FROM contribute_count WHERE prentice_count > 0 OR disciple_count > 0 ")
    List<Long> getContributeCountEntity();


    @Update("update contribute_count set prentice_count =#{prenticeCount} , disciple_count = #{discipleCount} where user_id =#{userId}")
    int updatePrenticeCount(@Param("userId") Long userId,@Param("prenticeCount")Long prenticeCount,@Param("discipleCount")Long discipleCount);

}
