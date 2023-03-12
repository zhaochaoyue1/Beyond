package com.example.student.serialize;

import com.example.student.desensitization.BaseRule;
import com.example.student.desensitization.CustomSerializer;
import com.example.student.desensitization.RuleItem;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * 脱敏序列化
 * 参考：https://blog.csdn.net/vbhfdghff/article/details/120551226
 * @description: MyJsonSerializer
 * @date: 2023/1/4 下午8:20
 * @author: zcy
 * @version: 1.0
 */
@Slf4j
public class MyJsonSerializer extends JsonSerializer<String> implements ContextualSerializer {

    /**
     * 脱敏规则
     */
    private BaseRule rule;

    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        System.out.println(value);
        gen.writeString(rule.apply(value));
    }

    @Override
    public JsonSerializer<?> createContextual(SerializerProvider prov, BeanProperty property) throws JsonMappingException {
        //获取对象属性上的自定义注解
        CustomSerializer customSerializer = property.getAnnotation(CustomSerializer.class);
        System.out.println(customSerializer);
        if (null != customSerializer) {
            try {
                //根据注解的配置信息，创建对应脱敏规则处理类
                this.rule = customSerializer.value().newInstance();
                //如果正则信息不为空，则使用注解上的正则初始化到对应的脱敏规则处理类中
                if (isNotBlank(customSerializer.pattern()) && isNotBlank(customSerializer.format())) {
                    this.rule.setRule(new RuleItem()
                            .setRegex(customSerializer.pattern())
                            .setFormat(customSerializer.format()));
                }
                return this;
            } catch (Exception e) {
                log.error("json转换处理异常", e);
            }
        }
        return prov.findValueSerializer(property.getType(), property);
    }

    private boolean isNotBlank(String str) {
        return null != str && str.trim().length() > 0;
    }
}
