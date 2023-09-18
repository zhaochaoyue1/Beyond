package com.example.javaio.serializable;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import lombok.Data;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @description: SerializablePratice
 * @date: 2023/8/11 上午9:51
 * @author: zcy
 * @version: 1.0
 */
public class SerializablePratice {
    public static void main(String[] args) throws IOException {
        /*MyEntity myEntity = new MyEntity();
        myEntity.setId(1);
        myEntity.setName("zcy");
        myEntity.setCurTime(new Date());
        System.out.println(JSONObject.toJSON(myEntity));
        String name = myEntity.getClass().getName();
        String path = "/Users/coohua/Documents/project/Beyond/student/src/test/java/com/example/javaio/serializable/" + name;
        //将数据序列化到本地
        Files.write(Paths.get(path), JSONObject.toJSONString(myEntity).getBytes());
        //将本地数据加载到内存
        Path path1 = Paths.get(path);
        if(Files.exists(path1)){
            byte[] bytes = Files.readAllBytes(path1);
            MyEntity myEntity1 = JSONObject.parseObject(new String(bytes, StandardCharsets.UTF_8), MyEntity.class);
            System.out.println(JSONObject.toJSON(myEntity1));
        }*/
        Map<String,String> maps = Maps.newHashMap();
        maps.put("1","a");
        maps.put("2","b");
        Iterator<Map.Entry<String, String>> iterator = maps.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, String> next = iterator.next();
            System.out.println(next.getKey());
        }
    }
}

@Data
class MyEntity {
    private Integer id;
    private String name;
    private Date curTime;
}
