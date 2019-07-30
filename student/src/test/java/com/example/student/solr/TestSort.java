package com.example.student.solr;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.*;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.GroupParams;
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
        String name="name:"+"\""+"红烧肉"+"\"";
        solrQuery.setQuery(name);
//        solrQuery.addField("*");
        solrQuery.setParam("fl","name");
        solrQuery.setFields("name");
        // 开启group的分组查询
        /*solrQuery.setParam(GroupParams.GROUP, true);
        // 设置分组的字段
        solrQuery.setParam(GroupParams.GROUP_FIELD, "name");*/
        solrQuery.setFacet(false);
        // facet字段
        solrQuery.addFacetField("name");
        // facet结果总数
        solrQuery.setFacetLimit(8);
        solrQuery.setSort("updateTime", SolrQuery.ORDER.desc);
        /*//设置查询的条数
        solrQuery.setRows(50);
        //设置查询的开始
        solrQuery.setStart(0);*/

        // 开始查询
        QueryResponse queryResponse = solrClient.query(solrQuery);
        List<FacetField> facetFields = queryResponse.getFacetFields();
        for (FacetField facetField : facetFields) {
            String facetName=facetField.getName();
            List<FacetField.Count> values = facetField.getValues();
            for (FacetField.Count count : values) {
                String name3 = count.getName();
                long num=count.getCount();
                System.out.println("facetName: "+facetName+"; name3: "+name3+"; num: "+num);
            }
        }

       // QueryResponse response = solrClient.query(solrQuery);
       /* SolrDocumentList documentList = response.getResults();
        Gson gson = new Gson();
        String listString = gson.toJson(documentList);
        List<ShortVedio> list = gson.fromJson(listString, new TypeToken<List<ShortVedio>>() {}.getType());
        for (SolrDocument solrDocument : documentList) {
            System.out.println("solrDocument==============" +solrDocument.get("name"));
        }*/
        /*GroupResponse groupResponse = response.getGroupResponse();
        List<GroupCommand> values = groupResponse.getValues();
        for (GroupCommand groupCommand : values) {
            String groupName = groupCommand.getName();
            // 每种分类字段下包含多少个值
            List<Group> groupValue = groupCommand.getValues();
            for (Group group : groupValue) {
                // 搜索结果
                SolrDocumentList result = group.getResult();
                for (SolrDocument solrDocument : result) {
                    Object name2 = solrDocument.getFieldValue("name");
                    System.out.println("groupName: "+groupName+"; name2: "+name2);
                }
            }
        }*/


    }
    @Test
    public void testSolrClient2()throws Exception {
        // 设置查询条件
        SolrQuery query = new SolrQuery();
        String name="name:"+"\""+"红烧肉"+"\"";
        //query.setQuery(name);
        // 返回列
        query.setFields("name");
        query.set("q",name);
        // 开启group的分组查询
        query.setParam(GroupParams.GROUP, true);
        // 设置分组的字段
        query.setParam(GroupParams.GROUP_FIELD, "name");
        query.setParam(GroupParams.GROUP_LIMIT,"10");
        // 设置返回行数
        query.setRows(10);
        QueryResponse qr = solrClient.query(query);
        GroupResponse groupResponse = qr.getGroupResponse();
        // 分组字段种类的list
        List<GroupCommand> values = groupResponse.getValues();
        for (GroupCommand groupCommand : values) {
            String groupName = groupCommand.getName();
            // 每种分类字段下包含多少个值
            List<Group> groupValue = groupCommand.getValues();
            for (Group group : groupValue) {
                // 搜索结果
                SolrDocumentList result = group.getResult();
                for (SolrDocument solrDocument : result) {
                    Object name2 = solrDocument.getFieldValue("name");
                    System.out.println("groupName: "+groupName+"; name2: "+name2);
                }
            }
        }


    }
    @Test
    public void queryFacet() throws Exception{
        SolrQuery query = new SolrQuery();
        String name="name:"+"\""+"红烧肉"+"\"";
        query.setQuery(name);
        // 不查询数据,只查询facet结果
        query.setFacet(true);
        // facet字段
        query.addFacetField("name");
        // facet结果总数
        query.setFacetLimit(8);
        // 开始查询
        QueryResponse queryResponse = solrClient.query(query);
        List<FacetField> facetFields = queryResponse.getFacetFields();
        for (FacetField facetField : facetFields) {
            String facetName=facetField.getName();
            List<FacetField.Count> values = facetField.getValues();
            for (FacetField.Count count : values) {
                String name2 = count.getName();
                long num=count.getCount();
                System.out.println("facetName: "+facetName+"; name: "+name2+"; num: "+num);
            }
        }
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
