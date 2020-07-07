package com.example.student.project.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @description: TestBetwennMapper
 * @date: 2020/6/24 下午5:53
 * @author: zcy
 * @version: 1.0
 */
@Repository
public interface TestBetweenMapper {
    @Insert("insert ignore into test_between (uuid,num) values (#{uuid},#{num}) ")
    void insert(@Param("uuid") String uuid, @Param("num") int num);
}
