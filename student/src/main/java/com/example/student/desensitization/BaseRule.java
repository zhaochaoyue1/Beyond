package com.example.student.desensitization;

import lombok.Data;
import org.springframework.cglib.core.internal.Function;


/**
 * @description: BaseRule
 * @date: 2023/1/4 下午8:16
 * @author: zcy
 * @version: 1.0
 */
//脱敏处理基类
@Data
public abstract class BaseRule implements Function<String, String> {
    /**
     * 脱敏规则对象
     */
    private RuleItem rule;
    @Override
    public String apply(String str) {
        if (null == str) {
            return null;
        }
        //初始化脱敏规则
        initRule();
        if (null == rule || null == rule.getRegex() || null == rule.getFormat()) {
            return str;
        }
        //正则替换
        return str.replaceAll(rule.getRegex(), rule.getFormat());
    }
    abstract void initRule();
}
