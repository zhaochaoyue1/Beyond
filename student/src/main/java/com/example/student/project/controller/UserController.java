package com.example.student.project.controller;

import com.example.student.project.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping(value = "/user/{id}/{name}")
    public User user(@PathVariable(name = "id") Integer id, @PathVariable("name") String name){
        return new User(id,name);
    }


}

