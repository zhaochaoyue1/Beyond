package com.example.student.Test;

import com.alibaba.fastjson.JSON;
import com.example.student.RunnableStatic;
import com.example.student.School;
import org.apache.commons.lang3.math.NumberUtils;

import java.text.NumberFormat;

public class TestStatic {
    public static void main(String[] args) {
        School build = School.builder().id(1)
                .address("1")
                .name("1").build();
        School build2 = School.builder().id(2)
                .address("2")
                .name("2").build();

        /*School school= build;
        build = build2;
        build2 = school;*/
        swap(build,build2);
        School build3 = School.builder().id(3)
                .address("3")
                .name("3").build();
        //build2=build3;
        System.out.println(JSON.toJSON(build));
        System.out.println(JSON.toJSON(build2));
        Integer a=128;
    }
    private static void swap(School x,School y){
        /*School temp = x;
        x= y;
        y = temp;*/
        School build3 = School.builder().id(3)
                .address("3")
                .name("3").build();
        x = build3;
        System.out.println("swap1:"+JSON.toJSON(x));
        System.out.println("sawap2"+JSON.toJSON(y));
    }
}
