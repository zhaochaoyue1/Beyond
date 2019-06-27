package com.example.student;

import com.example.student.project.dao.PeopleDao;
import com.example.student.project.domain.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;
public class RunableTest implements Runnable{

    private PeopleDao peopleDao;
    @Override
    public void run() {
        People peopleDesc = peopleDao.getPeopleDesc();
        Date createTime = peopleDesc.getCreateTime();
        Date date = new Date();
        long l = date.getTime()-createTime.getTime();
        if(l>10000){
            peopleDesc.setCreateTime(date);
            peopleDesc.setUpdateTime(date);
            peopleDao.insertPeople(peopleDesc);
        }
    }

    public PeopleDao getPeopleDao() {
        return peopleDao;
    }

    public RunableTest() {
    }

    public RunableTest(PeopleDao peopleDao) {
        super();
        this.peopleDao = peopleDao;
    }
}
