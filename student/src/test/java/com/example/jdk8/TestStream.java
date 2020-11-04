package com.example.jdk8;

import com.alibaba.fastjson.JSON;
import com.example.student.StudentApplication;
import com.example.student.project.controller.UserController;
import com.example.student.project.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {StudentApplication.class})
public class TestStream {
    @Autowired
    private ApplicationContext applicationContext;
    /*@Before
    public void before(){
        applicationContext = new AnnotationConfigApplicationContext(StudentApplication.class);
    }*/
    @Test
    public void test(){
        UserController bean = applicationContext.getBean(UserController.class);
        User user = bean.user(1, "赵超越");
        System.out.println(JSON.toJSONString(user));
    }
}
