package com.example.jdk8;

import com.alibaba.fastjson.JSONObject;
import com.example.student.Student;

/**
 * @description: IAdd
 * @date: 2022/5/3 下午5:06
 * @author: zcy
 * @version: 1.0
 */
public class IAdd {
    public static void main(String[] args) {
        System.out.println(iAdd());;
        System.out.println(JSONObject.toJSONString(getStudent()));
    }

    //常量时finally永远不会执行
    private static int iAdd(){
        int a = 2;
        try {
            if(1==1){
                throw new Exception();
            }
            return a;
        } catch (Exception e) {
            a=3;
            return a;
        } finally {
            a=4;
        }
    }

    //如果是引用类型，返回的永远是finally里的赋值
    public static Student getStudent(){
        Student student = new Student();
        try {
            student.setId(1);
            if(1==1){
                throw new Exception();
            }
            return student;
        } catch (Exception e) {
            student.setId(2);
            return student;
        } finally {
            student.setId(3);
        }
    }
}
