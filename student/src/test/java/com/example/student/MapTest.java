package com.example.student;

import java.io.Serializable;

public class MapTest implements Runnable {

    @Override
    public void run() {
        for(int i=1 ;i<=16000;i++){
            Student student = new Student();
            student.setId(i);
            student.setName("赵超越"+i);
            student.setAge(i);

        }
    }
}
