package com.example.student.project.dao;

import com.example.student.project.domain.People;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PeopleDao {

    People getPeople(@Param("name")String name);
    int updatePeople(People people);
    int batchUpdat(@Param("peoples")List<People> peoples);
    int insertPeople(People people);
    People getPeopleDesc();
}
