package com.example.student.enumEntity;

import lombok.Getter;

/**
 * @description: PrivacyTypeEnum
 * @date: 2023/1/4 下午3:14
 * @author: zcy
 * @version: 1.0
 */
@Getter
public enum PrivacyTypeEnum {
    /**
     * 自定义 （此项需设置脱敏范围）
     */
    CUSTOMER,
    /**
     * 姓名
     */
    NAME,
    /**
     * 省份证号
     */
    ID_CARD,
    /**
     * 手机号
     */
    PHONE,
    /**
     * 邮箱
     */
    EMAIL
}
