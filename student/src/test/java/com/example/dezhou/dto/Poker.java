package com.example.dezhou.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @description: Poker
 * @date: 2023/9/8 下午4:20
 * @author: zcy
 * @version: 1.0
 */
@Data
@AllArgsConstructor
public class Poker implements Serializable {
    private int num;
    private int sortNum;
    private int type;
}
