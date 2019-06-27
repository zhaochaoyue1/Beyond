package com.example.student.project.testApi;

import com.alibaba.fastjson.JSON;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/controller")
public class TestController {
   @Autowired
    private SolrClient solrClient;
    @GetMapping("/query")
    public void getAssociate(@RequestParam("key") String key) throws IOException, SolrServerException {
        SolrQuery sq = new SolrQuery();
        sq.setParam("name",key);
        sq.setStart(0);
        sq.setRows(10);
        sq.addSort("updateTime", SolrQuery.ORDER.desc);
        SolrClient solrClient = new HttpSolrClient("http://47.105.200.200:8080/solr/mysolr");

        QueryResponse query = solrClient.query(sq);
        SolrDocumentList results = query.getResults();
        for(SolrDocument solr:results){
            System.out.println(JSON.toJSONString(solr));
        }
    }
}
