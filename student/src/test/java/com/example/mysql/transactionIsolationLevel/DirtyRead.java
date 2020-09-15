package com.example.mysql.transactionIsolationLevel;

import com.alibaba.fastjson.JSONObject;
import com.example.student.StudentApplication;
import com.example.student.project.dao.StudentDao;
import com.example.student.project.domain.Student;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.annotation.Resource;

/**
 * @description: 脏读
 * @date: 2020/6/9 下午11:52
 * @author: zcy
 * @version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StudentApplication.class)
public class DirtyRead {
    @Resource
    private StudentDao studentDao;
    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;
    @Autowired
    private TransactionDefinition transactionDefinition;

    @Test
    public void test() {
        new Thread(this::inset).start();
        new Thread(this::readUnCommitted).start();
        new Thread(this::readCommitted).start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 写未提交
     */
    public  void inset(){
        TransactionStatus transaction = dataSourceTransactionManager.getTransaction(transactionDefinition);
        Student student = Student.builder().name("赵超越").age(25).build();
        studentDao.insert(student);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int a = 1/0;
    }

    /**
     * 读未提交
     */
    public void readUnCommitted(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
        defaultTransactionDefinition.setIsolationLevel(transactionDefinition.ISOLATION_READ_UNCOMMITTED);
        TransactionStatus transaction = dataSourceTransactionManager.getTransaction(defaultTransactionDefinition);
        Student student = studentDao.getStudentByName("赵超越");
        System.out.println("读未提交------- ："+JSONObject.toJSONString(student));
    }

    /**
     * 读未已提交
     */
    public void readCommitted(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
        defaultTransactionDefinition.setIsolationLevel(transactionDefinition.ISOLATION_READ_COMMITTED);
        TransactionStatus transaction = dataSourceTransactionManager.getTransaction(defaultTransactionDefinition);
        Student student = studentDao.getStudentByName("赵超越");
        System.out.println("读未已提交--------- ："+JSONObject.toJSONString(student));
    }
}
