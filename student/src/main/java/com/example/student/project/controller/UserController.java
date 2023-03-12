package com.example.student.project.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.student.annotation.PrivacyEncrypt;
import com.example.student.enumEntity.PrivacyTypeEnum;
import com.example.student.project.domain.User;
import com.example.student.serialize.PrivacySerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping(value = "/user/{id}/{name}")
    public User user(@PathVariable(name = "id") Integer id, @PathVariable("name") String name){
        try {
            Thread.sleep(id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new User(id,name);
    }

    @GetMapping(value = "/desensitization")
    public User desensitization(){
        User user = new User();
        user.setId(123);
        user.setIdCard("413026199903020634");
        user.setName("张三三");
        user.setPhone("18512340634");
        user.setEmail("18512340634@163.com");
        String s = JSONObject.toJSONString(user);
        System.out.println(s);
        return user;
    }

}

