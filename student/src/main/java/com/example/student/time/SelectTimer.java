package com.example.student.time;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.student.project.dao.PeopleDao;
import com.example.student.project.domain.People;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Date;

@Component
//@EnableScheduling
@Slf4j
public class SelectTimer {

    //private static final Logger log= LoggerFactory.getLogger(SelectTimer.class);
    /*@Resource
    private PeopleDao peopleDao;*/
    @Scheduled(fixedRate = 2000)
    @Transactional(rollbackFor = Exception.class)
    public void update(){
       /* log.info("哦哦哦哦哦哦哦info");
        Date date = new Date();
        People people = peopleDao.getPeople("赵超越");
        if(people==null){
            People people1 = new People();
            people1.setName("赵超越");
            people1.setCount(0);
            people1.setCreateTime(date);
            people1.setUpdateTime(date);
            peopleDao.insertPeople(people1);
        }else {
            int i = people.getCount() + 1;
            people.setUpdateTime(date);
            people.setCount(i);
            peopleDao.updatePeople(people);
        }
        int i=0;
        int j=0;
        int k=i/j;
        System.out.println(k);
        //log.info(JSON.toJSONString(people));*/
    }

    @Scheduled(fixedRate = 60000*30)
    public void solr(){
        String url="http://testsolr.ecosystemwan.com:8099/solr/mysolr/dataimport?command=full-import";
        RestTemplate template=new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        String body = template.exchange(url, HttpMethod.GET, entity, String.class).getBody();
        log.info("body---"+body);
        log.info("json------------"+JSON.toJSONString(body));
    }

}
