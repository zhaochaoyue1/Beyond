package com.example.student.project.controller;

import com.alibaba.fastjson.JSONArray;
import com.example.student.project.domain.Echars;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: Echars
 * @date: 2023/5/12 下午3:23
 * @author: zcy
 * @version: 1.0
 */
@RestController
public class EcharsController {

    @RequestMapping(value = "/getChart",method = RequestMethod.GET)
    @ResponseBody
    public Echars getChart() {

        ArrayList<String> x = new ArrayList<String>();
        for (int i = 1; i < 13; i++) {
            x.add(i+"");
        }
        String year2023 = "[15.41,15.06,15.37,14.33]";
        String year2022 = "[14.72,13.04,12.29,13.50,15.68,17.06,22.49,21.95,23.85,27.09,24.98,20.01]";
        String year2021 = "[35.68,30.18,27.76,23.27,19.43,14.96,16.02,15.09,12.70,13.34,17.72,16.92]";
        String year2020 = "[36.37,38.30,35.96,33.44,29.36,33.37,37.47,37.24,35.15,30.56,29.88,33.95]";
        List<Double> arr2023 = JSONArray.parseArray(year2023, Double.class);
        List<Double> arr2022 = JSONArray.parseArray(year2022, Double.class);
        List<Double> arr2021 = JSONArray.parseArray(year2021, Double.class);
        List<Double> arr2020 = JSONArray.parseArray(year2020, Double.class);
        List<List<Double>> y = new ArrayList<>();
        y.add(arr2023);
        y.add(arr2022);
        y.add(arr2021);
        y.add(arr2020);
        Echars echars = new Echars();
        echars.setX(x);
        echars.setY(y);
        echars.setTitle("sheng");
        return echars;
    }
}
