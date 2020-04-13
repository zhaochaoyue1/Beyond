package com.example.student.Test;

import com.alibaba.fastjson.JSON;
import com.example.student.Student;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

import static com.example.student.Test.SignManager.getSimpleDay;

public class TestClass {
    private static final int INTERVAL = 59;
    public static void main(String[] args) {
        /*long mill = System.currentTimeMillis();
        int i = ((Long) ((mill + 1000 * 60 * 60 * 8) / DateUtils.MILLIS_PER_DAY)).intValue();
        System.out.println(i);*/
        int function = function(100);
        LoggerFactory.getLogger(TestClass.class);
        System.out.println(function);
        Student zcy = Student.builder().id(1).name("zcy").age(25).build();
        Student student = new Student();
        student = (Student) zcy.clone();
        student.setAge(1);
        System.out.println("zcy :"+JSON.toJSONString(zcy));
        System.out.println("stu :"+JSON.toJSONString(student));

    }
    private static int function(Integer n){
        if(n==1){
            return 1;
        }
        return n+function(n-1);
    }

}
