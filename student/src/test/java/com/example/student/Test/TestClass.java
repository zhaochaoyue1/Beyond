package com.example.student.Test;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;

import static com.example.student.Test.SignManager.getSimpleDay;

public class TestClass {
    private static final int INTERVAL = 59;
    public static void main(String[] args) {
        /*long mill = System.currentTimeMillis();
        int i = ((Long) ((mill + 1000 * 60 * 60 * 8) / DateUtils.MILLIS_PER_DAY)).intValue();
        System.out.println(i);*/
        int function = function(100);
        System.out.println(function);
    }
    private static int function(Integer n){
        if(n==1){
            return 1;
        }
        return n+function(n-1);
    }

}
