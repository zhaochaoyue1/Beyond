package com.example;

import com.alibaba.fastjson.JSONObject;
import com.example.student.Student;
import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description: EverydayTest
 * @date: 2021/5/26 下午6:24
 * @author: zcy
 * @version: 1.0
 */
public class EverydayTest {
    public static void main(String[] args) {
        List<Student> list =  new ArrayList<>();
        list.add(Student.builder().name("zcy1").build());
        list.add(Student.builder().name("zcy1").build());
        list.add(Student.builder().name("zcy1").build());
        list.add(Student.builder().name("zcy1").build());
        list.add(Student.builder().name("zcy2").build());
        list.add(Student.builder().name("zcy2").build());
        list.add(Student.builder().name("zcy2").build());
        list.add(Student.builder().name("zcy2").build());
        list.add(Student.builder().name("zcy2").build());
        list.add(Student.builder().name("zcy3").build());
        list.add(Student.builder().name("zcy3").build());
        list.add(Student.builder().name("zcy3").build());
        list.add(Student.builder().name("zcy3").build());
        List<String> zcys = Lists.newArrayList();
        zcys.add("zcy1");
        zcys.add("zcy3");
        zcys.add("zcy2");
        Collections.sort(list,((o1, o2) -> {
            int i = zcys.indexOf(o1.getName());
            int i1 = zcys.indexOf(o2.getName());
            return i1-i;
        }));
        System.out.println(JSONObject.toJSONString(list));
    }
}
class TestHeap{
    public static  int a = 1;
}

