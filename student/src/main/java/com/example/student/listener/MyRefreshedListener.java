package com.example.student.listener;

import com.example.student.project.domain.Student;
import com.example.student.project.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class MyRefreshedListener  implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext applicationContext = event.getApplicationContext();
        StudentService bean = applicationContext.getBean(StudentService.class);
        bean.inset(1);
    }
}
