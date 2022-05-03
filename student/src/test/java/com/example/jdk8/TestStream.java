package com.example.jdk8;

import com.alibaba.fastjson.JSON;
import com.example.student.StudentApplication;
import com.example.student.project.controller.UserController;
import com.example.student.project.domain.EcpmGray;
import com.example.student.project.domain.User;
import com.example.student.project.service.EcpmService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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
        EcpmService bean = applicationContext.getBean(EcpmService.class);
        //bean.delRedis();
        List<EcpmGray> select = bean.select();
        System.out.println(JSON.toJSONString(select));
    }
}
