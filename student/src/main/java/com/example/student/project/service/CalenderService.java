package com.example.student.project.service;

public interface CalenderService {
    int saveCalender(String id,String text,Long time);

    boolean get(String id);
}
