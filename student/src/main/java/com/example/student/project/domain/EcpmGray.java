package com.example.student.project.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: EcpmGray
 * @date: 2021/8/17 下午5:12
 * @author: zcy
 * @version: 1.0
 */
@Data
public class EcpmGray implements Serializable {
    private Long userId;
    private String value;
    private Long ecpm;
}
