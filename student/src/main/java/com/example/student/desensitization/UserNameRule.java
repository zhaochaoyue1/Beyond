package com.example.student.desensitization;

/**
 * @description: UserNameRule
 * @date: 2023/1/4 下午8:22
 * @author: zcy
 * @version: 1.0
 */
//姓名脱敏处理类
public class UserNameRule extends BaseRule {

    /**
     * 仅显示最后一个汉字
     */
    @Override
    void initRule() {
        setRule(new RuleItem()
                .setRegex("\\S*(\\S)")
                .setFormat("**$1"));
    }
}
