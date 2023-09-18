package com.example.student.project.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @description: ColumnarModel
 * @date: 2023/5/12 下午3:22
 * @author: zcy
 * @version: 1.0
 */
@Data
public class ColumnarModel implements Serializable {
    /**
     * 柱状图的标题
     */
    private String title;

    /**
     * 顶部数据
     */
    private List<String> legendData;

    /**
     * 横坐标数据
     */
    private List<String> xData;

    /**
     * 柱状图上的具体数据
     */
    private List<Integer> serieData;
}
