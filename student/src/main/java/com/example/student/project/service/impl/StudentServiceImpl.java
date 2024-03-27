package com.example.student.project.service.impl;

import com.example.student.project.dao.StudentDao;
import com.example.student.project.domain.Student;
import com.example.student.project.service.StudentService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @description: StudentServiceImpl
 * @date: 2020/7/3 下午6:05
 * @author: zcy
 * @version: 1.0
 */
@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentDao studentDao;
    @Override
    public void inset(int age) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Student zcy = Student.builder().age(age).id((long) age).name("zcy").build();
        //studentDao.insert(zcy);
        System.out.println("测试ApplicationListener 监听");
    }


}
