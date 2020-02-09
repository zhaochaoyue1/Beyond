package com.example.javaReflect;

import com.alibaba.fastjson.JSON;
import com.example.student.School;
import com.example.student.Student;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class TestReflect {
    public static void main(String[] args) {
        Student student = new Student(1,"赵超越",22,new School(1,"固始一中","固始县"));
        Class cl = student.getClass();
        try {
            Field[] fields = cl.getDeclaredFields();
            AccessibleObject.setAccessible(fields,true);
            for (Field f:fields){
                Object o = f.get(student);
                System.out.println(JSON.toJSONString(o));
            }
            Field age = cl.getDeclaredField("age");
            age.setAccessible(true);
            Object o = age.get(student);
            age.set(student,33);
            System.out.println(JSON.toJSONString(o));
            System.out.println(JSON.toJSONString(student));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
