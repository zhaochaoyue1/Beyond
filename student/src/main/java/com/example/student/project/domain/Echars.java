package com.example.student.project.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @description: Echars
 * @date: 2023/5/12 下午8:01
 * @author: zcy
 * @version: 1.0
 */
@Data
public class Echars implements Serializable {
    private String title;
    private List<String> x;
    private List<List<Double>> y;
}
