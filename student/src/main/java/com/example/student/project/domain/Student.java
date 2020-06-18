package com.example.student.project.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @description: Student
 * @date: 2020/6/9 下午11:57
 * @author: zcy
 * @version: 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
    private Long id;
    private String name;
    private Integer age;
    private Date createTime;
    private Date updateTime;
}
