package com.example.student.project.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;


@Slf4j
@Controller
//@RequestMapping("/test")
public class ViewController {
    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView model = new ModelAndView();
        HashMap<String, String> map = new HashMap<>();
        map.put("msg2","msg test 2");

        model.addObject("msg","springboot 集成jsp");
        model.setViewName("index");
        model.getModelMap().addAllAttributes(map);
        return model;
    }
    @RequestMapping("/index2")
    public String index2(Model model){
        HashMap<String, String> map = new HashMap<>();
        map.put("msg2","msg test 2");

        model.addAttribute("msg","springboot 集成jsp");
        model.addAllAttributes(map);
        return "index";
    }
}
