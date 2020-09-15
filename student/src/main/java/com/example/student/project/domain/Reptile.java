package com.example.student.project.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: Reptile
 * @date: 2020/8/10 上午10:46
 * @author: zcy
 * @version: 1.0
 */
@Data
public class Reptile implements Serializable {
    private String time;
    private String title;
    private String mp3;
}
