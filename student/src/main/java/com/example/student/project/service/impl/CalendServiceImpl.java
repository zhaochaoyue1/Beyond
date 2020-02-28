package com.example.student.project.service.impl;

import com.example.student.project.dao.CaladerDao;
import com.example.student.project.service.CalenderService;
import org.springframework.beans.factory.annotation.Autowired;

public class CalendServiceImpl implements CalenderService {
    @Autowired
    private CaladerDao caladerDao;

    @Override
    public int saveCalender(String id, String text,Long time) {
        caladerDao.saveCalender(id,text,time);
        return 0;
    }
}
