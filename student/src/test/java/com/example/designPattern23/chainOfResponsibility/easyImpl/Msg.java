package com.example.designPattern23.chainOfResponsibility.easyImpl;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: Msg 消息对象
 * @date: 2020/6/11 下午9:14
 * @author: zcy
 * @version: 1.0
 */
@Data
public class Msg implements Serializable {
    private String msg;
}
