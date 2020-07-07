package com.example.simpleTimeLimiter;

import com.example.student.StudentApplication;
import com.example.student.project.dao.StudentDao;
import com.example.student.project.service.StudentService;
import com.google.common.util.concurrent.SimpleTimeLimiter;
import com.google.common.util.concurrent.UncheckedTimeoutException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description: Test
 * @date: 2020/7/3 下午5:51
 * @author: zcy
 * @version: 1.0
 */
@SpringBootTest(classes = StudentApplication.class)
@RunWith(SpringRunner.class)
public class Test {
    @Autowired
    private StudentService studentService;

    private static SimpleTimeLimiter simpleTimeLimiter = SimpleTimeLimiter.create(new ThreadPoolExecutor(5,
            20,
            30,
            TimeUnit.MINUTES,
            new ArrayBlockingQueue(1024)));

    @org.junit.Test
    public void test() {
        for (int i = 0; i < 10; i++) {
            StudentService studentService = simpleTimeLimiter.newProxy(this.studentService, StudentService.class, 5L, TimeUnit.SECONDS);
            try {
                studentService.inset(i);
            } catch (UncheckedTimeoutException e) {
                e.printStackTrace();
                System.out.println("等待超时");
                studentService.inset(i);
            }
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
