package com.example.mongodb;

import com.alibaba.fastjson.JSONObject;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;

/**
 * @description: Test
 * @date: 2021/12/16 下午5:07
 * @author: zcy
 * @version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        //easyDriver();
        String s = "012345678";
        String s1 = StringUtils.substringBefore(s, "0");
        System.out.println(s1);
    }

    //简单的链接到数据库
    private static void easyDriver(){
        MongoClient mongoClient = new MongoClient("localhost",27017);
        //连接到数据库
        MongoDatabase col = mongoClient.getDatabase("table2");
        System.out.println("connect to database successfully");
        MongoCollection<Document> col1 = col.getCollection("col");
        FindIterable<Document> documents = col1.find();
        MongoCursor<Document> iterator = documents.iterator();
        while(iterator.hasNext()){
            System.out.println(JSONObject.toJSONString(iterator.next()));
        }

        //并集查询
        BasicDBObject basicDBObject = new BasicDBObject();
        basicDBObject.put("$gt",100);
        basicDBObject.put("$lt",200);

        FindIterable<Document> likes = col1.find(Filters.gte("likes", basicDBObject));

        MongoCursor<Document> iterator1 = likes.iterator();

        while(iterator1.hasNext()){
            System.out.println(JSONObject.toJSONString(iterator1.next()));
        }

    }
}
