package com.example.student.desensitization;

/**
 * @description: IdCardRule
 * @date: 2023/1/4 下午8:19
 * @author: zcy
 * @version: 1.0
 */
//身份证号脱敏处理类
public class IdCardRule extends BaseRule {

    /**
     * 仅显示前6位和后4位
     */
    @Override
    void initRule() {
        setRule(new RuleItem()
                .setRegex("(\\d{6})\\d*(\\w{4})")
                .setFormat("$1********$2"));
    }

}
