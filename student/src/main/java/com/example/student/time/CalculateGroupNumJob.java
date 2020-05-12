package com.example.student.time;

import com.example.student.util.DateTimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Desc
 * @Author Fengcongyue
 * @Date 2019/9/4
 **/
@Slf4j
@Component
public class CalculateGroupNumJob {


    @Scheduled(cron = "0 0/30 * * * ?")
    public void test(){
        log.info("时间："+ DateTimeUtils.formatYYYYMMDDHHMMSS(new Date()));
    }


    @Scheduled(cron = "0 0 17 * * ?")
    public void test2(){
        log.info("时间："+ DateTimeUtils.formatYYYYMMDDHHMMSS(new Date()));
    }

    @Scheduled(cron = "0 12 16 * * ?")
    public void test3(){
        log.info("时间A："+ DateTimeUtils.formatYYYYMMDDHHMMSS(new Date()));
    }

    @Scheduled(cron = "0 12 16 ? * *")
    public void test4(){
        log.info("时间B："+ DateTimeUtils.formatYYYYMMDDHHMMSS(new Date()));
    }
}