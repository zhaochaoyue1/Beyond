package com.example.student;

import com.example.student.project.dao.PeopleDao;
import com.example.student.project.domain.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.Callable;

public class RunableTest implements Callable {
    private PeopleDao peopleDao;
    @Override
    public Object call() throws Exception {
        People peopleDesc = peopleDao.getPeopleDesc();
        Date createTime = peopleDesc.getCreateTime();
        Date date = new Date();
        long l = date.getTime()-createTime.getTime();
        if(l>10000){
            peopleDesc.setCreateTime(date);
            peopleDesc.setUpdateTime(date);
            peopleDao.insertPeople(peopleDesc);
        }
        return null;
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
