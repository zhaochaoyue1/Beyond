package com.example.student.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ViewController {
    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("msg","springboot 集成jsp");
        return "/index";
    }
}
