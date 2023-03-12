package com.example.proxy.test;

import com.example.student.project.service.TestAop;
import com.example.student.StudentApplication;
import net.sf.cglib.core.DebuggingClassWriter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @description: TestAop
 * @date: 2022/12/23 下午4:06
 * @author: zcy
 * @version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StudentApplication.class)
public class TestAopTransfer {
    @Resource
    private TestAop testAop;

    @Test
    public void main() {
        testAop.test1();
        testAop.test2();
        testAop.test3();
    }
}
