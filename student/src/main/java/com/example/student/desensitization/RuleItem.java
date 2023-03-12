package com.example.student.desensitization;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @description: RuleItem
 * @date: 2023/1/4 下午8:17
 * @author: zcy
 * @version: 1.0
 */
//脱敏对象
@Data
@Accessors(chain = true)
public class RuleItem {

    /**
     * 正则
     */
    private String regex;

    /**
     * 格式化显示
     */
    private String format;
}
