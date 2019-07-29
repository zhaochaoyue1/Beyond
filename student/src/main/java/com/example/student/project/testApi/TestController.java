package com.example.student.project.testApi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controller")
public class TestController {
  /* @Autowired
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
    }*/
}
