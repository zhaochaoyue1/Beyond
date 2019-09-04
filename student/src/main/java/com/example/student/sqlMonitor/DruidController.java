package com.example.student.sqlMonitor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * druid 监控
 * 
 * @author ruoyi
 */
@Controller
@RequestMapping("/monitor/data")
public class DruidController
{
    private String prefix = "/monitor/druid";
    @GetMapping()
    public String index()
    {
        return "redirect:" + prefix + "/index";
    }
}
