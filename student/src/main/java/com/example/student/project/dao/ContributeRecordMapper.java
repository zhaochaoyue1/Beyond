package com.example.student.project.dao;

import com.example.student.project.domain.ContributeRecordEntity;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContributeRecordMapper {


    @Select("select sum(prentice_money) as prenticeMoney, sum(disciple_money) as discipleMoney from " +
            "contribute_record where user_id = #{userId}")
    ContributeRecordEntity getSum(@Param("userId") Long userId);

}
