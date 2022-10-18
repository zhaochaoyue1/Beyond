package com.example.javaio;

import cn.hutool.core.io.FileUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.JSONToken;
import io.netty.util.CharsetUtil;
import org.json.JSONException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: JsonFileToJson
 * @date: 2022/6/16 下午9:13
 * @author: zcy
 * @version: 1.0
 */
public class JsonFileToJson {
    public static void main(String[] args) throws JSONException {
        String url = "/Users/coohua/Downloads/产品需求文档/我爱点点消优化文档html_0607/江南小院导出数值";
       // String s = FileUtil.readString(url, CharsetUtil.UTF_8);
        //System.out.println(s);
        File file = FileUtil.file(url);
        File[] files = file.listFiles();
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            File file1 = files[i];
            if(!file1.isFile()){
                continue;
            }
            String name = file1.getName();
            if(!name.endsWith(".json")){
                continue;
            }
            String s1 = FileUtil.readString(file1, CharsetUtil.UTF_8);
            Object o = JSON.parse(s1);
            //System.out.println(o.getClass());
            if(o instanceof JSONObject){
                JSONObject object = JSONObject.parseObject(s1);
                list.add(object);
            }else if(o instanceof JSONArray){
                List<JSONObject> jsonObjects = JSONArray.parseArray(s1,JSONObject.class);
                list.add(jsonObjects);
            }else {
                list.add(s1);
            }
            //list.add(s1);
        }
        System.out.println(JSONObject.toJSONString(list));
        System.out.println(list.size());
        /*if(o instanceof JSONObject){
            List<JSONObject> jsonObjects = JSONUtil.toList(s, JSONObject.class);
            System.out.println(jsonObjects.toString());
        }else if(o.getClass().equals(JSONArray.class)){
            List<JSONObject> jsonObjects = JSONUtil.toList(s, JSONObject.class);
            System.out.println(jsonObjects.toString());
        }else if(o instanceof Long){
            System.out.println((Long)o);
        }*/

    }
}
