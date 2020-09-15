package com.example.mysql.between;

import com.example.student.StudentApplication;
import com.example.student.project.dao.TestBetweenMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: Test
 * @date: 2020/6/24 下午8:26
 * @author: zcy
 * @version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StudentApplication.class)
public class Test {
    @Autowired
    private TestBetweenMapper mapper;
    private static AtomicInteger num= new AtomicInteger();

    @org.junit.Test
    public void test() {
        for (int i = 0; i < 4; i++) {
            new Thread(() -> {
                for (int j = 0; j < 25000000; j++) {
                    UUID uuid = UUID.randomUUID();

                    mapper.insert(uuid.toString(),num.incrementAndGet());
                }
            }).start();
        }
        try {
            Thread.sleep(1000 * 60 * 60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
