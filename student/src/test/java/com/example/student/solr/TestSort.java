package com.example.student.solr;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: student
 * @Date: 2019/7/23 23:15
 * @Author: Mr.Zhao
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSort {
    @Resource
    private SolrTemplate solrTemplate;
    @Autowired
    private SolrClient solrClient;

    @Test
    public void testSolrClient()throws Exception {
        SolrQuery solrQuery  = new SolrQuery();
        solrQuery.setQuery("*:*");
//        solrQuery.addField("*");
        solrQuery.add("q","id:4567");

        solrQuery.setSort("id", SolrQuery.ORDER.asc);
        //设置查询的条数
        solrQuery.setRows(50);
        //设置查询的开始
        solrQuery.setStart(0);
        QueryResponse response = solrClient.query(solrQuery);
        SolrDocumentList documentList = response.getResults();
        Gson gson = new Gson();
        String listString = gson.toJson(documentList);
        List<ShortVedio> list = gson.fromJson(listString, new TypeToken<List<ShortVedio>>() {}.getType());
        /*for (SolrDocument solrDocument : documentList) {
            System.out.println("solrDocument==============" +solrDocument);
        }*/
        System.out.println(JSON.toJSON(list));

    }
    @Test
    public void TestSolrLenove(){
        /*solrTemplate.set
        Query query = new SimpleQuery("*:*");
        query.setRows(10);
        query.setOffset(0);
        ScoredPage<ShortVedio> shortVedios = solrTemplate.queryForPage(query, ShortVedio.class);
        System.out.println(JSON.toJSON(shortVedios));*/
    }
}
