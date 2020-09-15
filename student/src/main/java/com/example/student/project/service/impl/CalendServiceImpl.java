package com.example.student.project.service.impl;

import com.example.student.project.dao.CaladerDao;
import com.example.student.project.service.CalenderService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalendServiceImpl implements CalenderService {
    @Autowired
    private CaladerDao caladerDao;

    @Override
    public int saveCalender(String id, String text, Long time) {
        caladerDao.saveCalender(id, text, time);
        return 0;
    }

    @Override
    public boolean get(String id) {
        String calendar = caladerDao.getCalendar(id);
        if(StringUtils.isEmpty(calendar)) {
            return true;
        }
        return false;
    }
}
