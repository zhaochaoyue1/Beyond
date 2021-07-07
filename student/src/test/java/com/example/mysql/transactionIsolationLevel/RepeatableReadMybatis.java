package com.example.mysql.transactionIsolationLevel;

import com.alibaba.fastjson.JSONObject;
import com.example.student.StudentApplication;
import com.example.student.project.dao.StudentDao;
import com.example.student.project.domain.Student;
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
import java.util.List;

/**
 * @description: 不可重复读
 * @date: 2020/6/9 下午11:52
 * @author: zcy
 * @version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StudentApplication.class)
public class RepeatableReadMybatis {
    @Resource
    private StudentDao studentDao;
    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;
    @Autowired
    private TransactionDefinition transactionDefinition;

    @Test
    public void test() {
        //repeatableRead();
        new Thread(this::insert).start();
        new Thread(this::select).start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 可重复读
     */
    public void repeatableRead() {
        //插入前查询
        Student s1 = studentDao.getStudentByName("赵超越");
        System.out.println("s1 :" + JSONObject.toJSONString(s1));
        //插入数据
        Student student = Student.builder().name("赵超越").age(25).build();
        studentDao.insert(student);
        //插入后查询
        Student s2 = studentDao.getStudentByName("赵超越");
        System.out.println("s2 :" + JSONObject.toJSONString(s2));
        //修改年纪
        studentDao.updateByName("赵超越",26);
        //修改年纪后查询
        Student s3 = studentDao.getStudentByName("赵超越");
        System.out.println("s3 :" + JSONObject.toJSONString(s3));

    }

    public void insert(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Student student = Student.builder().name("zcy").age(1).build();
        studentDao.insert(student);
    }

    public void select(){
        DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
        //设置隔离级别 可重复读
        defaultTransactionDefinition.setIsolationLevel(transactionDefinition.ISOLATION_REPEATABLE_READ);
        TransactionStatus transaction = dataSourceTransactionManager.getTransaction(defaultTransactionDefinition);
        try {
            dataSourceTransactionManager.getDataSource().getConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<Student> s = studentDao.getStudentByNameList("zcy");
        System.out.println(JSONObject.toJSONString(s));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Student> s2 = studentDao.getStudentByNameList("zcy");
        System.out.println(JSONObject.toJSONString(s2));
        int zcy = studentDao.updateByName("zcy", 25);
        System.out.println("修改数量："+ zcy);
        List<Student> s3 = studentDao.getStudentByNameList("zcy");
        System.out.println(JSONObject.toJSONString(s3));
        dataSourceTransactionManager.commit(transaction);
    }
}
