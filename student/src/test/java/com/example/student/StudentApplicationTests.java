package com.example.student;

import com.alibaba.fastjson.JSON;
import com.example.student.project.dao.PeopleDao;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentApplicationTests {
    @Value("${spring.datasource.url}")
    private String url;
    @Resource
    private PeopleDao peopleDao;
    @Test
    public void contextLoads() {

    }
    @Test
    public void testConcurrenry(){
        RunableTest runableTest1 = new RunableTest(peopleDao);
        RunableTest runableTest2= new RunableTest(peopleDao);
        runableTest1.run();
        runableTest2.run();

    }
    @Test
    public void TestSkipList(){
        ConcurrentSkipListMap<Integer, Object> skipListMap = new ConcurrentSkipListMap<>();
        //ConcurrentHashMap<Integer, Object> hashMap = new ConcurrentHashMap<>();
        long l = System.currentTimeMillis();
        for(int i=1 ;i<=16000;i++){
            Student student = new Student();
            student.setId(i);
            student.setName("赵超越"+i);
            student.setAge(i);
            skipListMap.put(i,student);
        }

        long l1 = System.currentTimeMillis();
        System.out.println("---------------------------------"+(l1-l));
        long l2 = System.nanoTime();
        Object o = skipListMap.get(13568);
        long l3 = System.nanoTime();
        System.out.println("-----------------------------------"+(l3-l2));
    }
    @Test
    public void testYUSEFU(){
        //先给这41个人按顺序排列，初始数值是key值；
        //Map<Integer,Integer> map=new HashMap<>();
        List list=new LinkedList();
        for(int i=1;i<42;i++){
            //map.put(i,i);
            list.add(i);
        }

        for(list.size();list.size()>2;){
            int i1 = list.size() / 3;
            for(int i=0;i<i1;i++){

            }

        }
    }
    @Test
    public void testString(){
        String name="小明";
        name=stringToSwap(name);
        System.out.println(name);
    }
    private String stringToSwap(String name){
        if(name.equals("小明")){
            name="小红";
        }
        return name;
    }

    @Test
    public void solrTest() throws IOException, SolrServerException {
        SolrQuery sq = new SolrQuery();
        //sq.setParam("name","肉");
        sq.set("q","name:肉");
        //sq.setParam("indent",true);
        //sq.setParam("wt","json");
        sq.set("indent","true");
        sq.set("wt","json");
        sq.set("start",0);
        sq.set("rows",10);
        //sq.set("fl","name,updateTime,title,lable");
        sq.set("fl","name");
        sq.set("qf","name^10");
        //sq.setStart(0);
        //sq.setRows(10);
        sq.addSort("updateTime", SolrQuery.ORDER.desc);
        sq.addSort("onlieTime", SolrQuery.ORDER.desc);
        //sq.setRequestHandler("/browse");
        SolrClient solrClient = new HttpSolrClient("http://47.105.200.200:8080/solr/mysolr");

        QueryResponse query = solrClient.query(sq);
        SolrDocumentList results = query.getResults();
        for(SolrDocument solr:results){
            //String name = (String )solr.get("name");
            System.out.println(JSON.toJSONString(solr));
            //System.out.println(name);
        }
    }

    @Test
    public void testSort(){
        long l = System.nanoTime();
        Set<Long> longs = new HashSet<>();
        longs.add(1L);
        longs.add(6L);
        longs.add(5L);
        longs.add(0L);
        Object[] objects = longs.toArray();
        Arrays.sort(objects);
        long l1 = System.nanoTime();
        System.out.println(l1-l);
        System.out.println(JSON.toJSONString(longs));
    }

    @Test
    public void testList(){


    }
}
