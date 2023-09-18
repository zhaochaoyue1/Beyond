package com.example.dezhou.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @description: Hourse
 * @date: 2023/9/8 下午4:25
 * @author: zcy
 * @version: 1.0
 */
@Data
public class House implements Serializable {
    private int id;
    private List<Gamer> gamers;
    private List<Poker> pokers;
}
