package com.example.elasticsearch;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.json.JSONUtil;
import com.example.student.StudentApplication;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.*;

/**
 * @description: ElasticSearchTest
 * @date: 2023/7/12 下午4:40
 * @author: zcy
 * @version: 1.0
 */
@SpringBootTest(classes = StudentApplication.class)
@RunWith(SpringRunner.class)
@Slf4j
public class ElasticSearchTest {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Test
    public void test01() throws IOException {

        for (int i = 0; i < 10; i++) {

            String id = UUID.randomUUID().toString().substring(0, 3);
            //构建想要存储的对象
            Map<String, Object> map = new HashMap<>();
            map.put("id", id);
            map.put("publishTime", new Date());
            map.put("layout", RandomUtil.randomInt(1000));
            map.put("images", RandomUtil.randomNumbers(10).toString());
            map.put("authorId", RandomUtil.randomInt(1000));
            map.put("content", RandomUtil.randomNumbers(10).toString());

            //指定要存入数据的库
            IndexRequest indexRequest
                    = new IndexRequest("app_info_article").id(id).source(map);

            //创建索引 并保存至es库中
            restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        }
    }

    @Test
    public void test02() throws IOException {
        //构建搜索请求对象,需要指定索引库名称
        SearchRequest searchRequest = new SearchRequest("app_info_article");
        //条件构建器
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //布尔查询
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();

        //查询时间publishTime大于2021-09-21 15:00:00 的所有信息
        RangeQueryBuilder rangeQueryBuilder = QueryBuilders
                .rangeQuery("publishTime")
                .gt(DateUtil.parse("2021-09-21 15:00:00").toJdkDate());
        boolQueryBuilder.filter(rangeQueryBuilder);

        searchSourceBuilder.query(boolQueryBuilder);
        //分页
        searchSourceBuilder.from(0);
        searchSourceBuilder.size(10);
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

        List<Map> articleList = new ArrayList<>();

        SearchHit[] hits = searchResponse.getHits().getHits();
        for (SearchHit hit : hits) {

            String sourceAsString = hit.getSourceAsString();
            Map map = JSONUtil.toBean(sourceAsString,Map.class);
            articleList.add(map);
        }
        System.out.println(articleList);
    }
}
