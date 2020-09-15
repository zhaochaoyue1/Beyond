package com.example.mysql.transactionIsolationLevel;

import com.alibaba.fastjson.JSONObject;
import com.example.student.StudentApplication;
import com.example.student.project.dao.StudentDao;
import com.example.student.project.domain.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.annotation.Resource;
import java.sql.SQLException;

/**
 * @description: 不可重复读
 * @date: 2020/6/9 下午11:52
 * @author: zcy
 * @version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StudentApplication.class)
public class NonRepeatableRead {
    @Resource
    private StudentDao studentDao;
    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;
    @Autowired
    private TransactionDefinition transactionDefinition;
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    String lock1 = "lock";

    @Test
    public void test() {
        new Thread(this::inset).start();
        //读已提交
        new Thread(this::readCommitted).start();
        //可重复读
        new Thread(this::repeatableRead).start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 写以提交
     */
    public void inset() {
        DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus transaction = dataSourceTransactionManager.getTransaction(defaultTransactionDefinition);
        try {
            dataSourceTransactionManager.getDataSource().getConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        synchronized (lock1) {
            try {
                lock1.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Student student = Student.builder().name("赵超越").age(25).build();
        studentDao.insert(student);
        dataSourceTransactionManager.commit(transaction);
    }

    /**
     * 读已提交
     */
    public void readCommitted() {
        DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
        //设置隔离级别 读已提交
        defaultTransactionDefinition.setIsolationLevel(transactionDefinition.ISOLATION_READ_COMMITTED);
        TransactionStatus transaction = dataSourceTransactionManager.getTransaction(defaultTransactionDefinition);
        //获取sql执行器
        SqlSession session = this.sqlSessionFactory.openSession(false);
        StudentDao mapper = session.getMapper(StudentDao.class);
        Student student1 = mapper.getStudentByName("赵超越");
        System.out.println("读未已提交1------- ：" + JSONObject.toJSONString(student1));
        synchronized (lock1) {
            lock1.notify();
        }
        try {
            //睡五秒让insert先执行
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //清除mybatis层缓存，Mybatis框架有一级缓存，在同一次回话中相同的查询，第二次查询时会走
        //mybatis缓存，不会走库，所以你任何隔离级别都会重复读
        session.clearCache();
        System.out.println("读未已提交隔离级别：" + defaultTransactionDefinition.getIsolationLevel());
        //Student student2 = studentDao.getStudentByAge(25);
        Student student2 = mapper.getStudentByName("赵超越");
        System.out.println("读未已提交2------- ：" + JSONObject.toJSONString(student2));

    }

    /**
     * 可重复读
     */
    public void repeatableRead() {
        DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
        //设置隔离级别 可重复读
        defaultTransactionDefinition.setIsolationLevel(transactionDefinition.ISOLATION_REPEATABLE_READ);
        TransactionStatus transaction = dataSourceTransactionManager.getTransaction(defaultTransactionDefinition);
        //获取sql执行器
        SqlSession session = this.sqlSessionFactory.openSession(false);
        StudentDao mapper = session.getMapper(StudentDao.class);
        Student student1 = mapper.getStudentByName("赵超越");
        System.out.println("可重复读1------- ：" + JSONObject.toJSONString(student1));
        synchronized (lock1) {
            lock1.notify();
        }
        try {
            //睡五秒让insert先执行
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //清除mybatis层缓存，Mybatis框架有一级缓存，在同一次回话中相同的查询，第二次查询时会走
        //mybatis缓存，不会走库，所以你任何隔离级别都会重复读
        session.clearCache();
        System.out.println("可重复读隔离级别：" + defaultTransactionDefinition.getIsolationLevel());
        //Student student2 = studentDao.getStudentByAge(25);
        Student student2 = mapper.getStudentByName("赵超越");
        System.out.println("可重复读2------- ：" + JSONObject.toJSONString(student2));
    }
}
