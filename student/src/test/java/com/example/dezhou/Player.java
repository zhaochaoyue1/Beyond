package com.example.dezhou;

import cn.hutool.core.stream.CollectorUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.dezhou.dto.Gamer;
import com.example.dezhou.dto.Poker;
import com.example.dezhou.judgment.JudgmentClass;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @description: Player
 * @date: 2023/9/8 下午8:26
 * @author: zcy
 * @version: 1.0
 */
public class Player {
    private final static List<Poker> lists = new ArrayList<>(52);
    static {
        for (int i = 0; i < 13; i++) {
            int num = i+1;
            if(num == 1){
                lists.add(new Poker(num,14,1));
                lists.add(new Poker(num,14,2));
                lists.add(new Poker(num,14,3));
                lists.add(new Poker(num,14,4));
            }else {
                lists.add(new Poker(num,num,1));
                lists.add(new Poker(num,num,2));
                lists.add(new Poker(num,num,3));
                lists.add(new Poker(num,num,4));
            }

        }
    }
    private static Map<Integer,Integer> tj = new HashMap<>();
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 100000; i++) {
            cal();
        }
        System.out.println(JSONObject.toJSONString(tj));
    }

    private static void cal(){
        Collections.shuffle(lists);
        Queue<Poker> queue = new ArrayDeque<>(lists);
        List<Gamer> gamers = new ArrayList<>();
        int peopleNum = 6;
        for (int i = 1; i < peopleNum+1; i++) {
            Gamer gamer = new Gamer();
            gamer.setId(i);
            gamers.add(gamer);
        }
        //这个无所谓先发底牌
        List<Poker> dipai = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            dipai.add(queue.poll());
        }
        for (int i = 0; i < peopleNum *2; i++) {
            if(i<peopleNum){
                List<Poker> list = new ArrayList<>();
                list.add(queue.poll());
                gamers.get(i).setHandle(list);
            }else {
                Gamer gamer = gamers.get(i%peopleNum);
                List<Poker> handle = gamer.getHandle();
                handle.add(queue.poll());
                List<Poker> allPoker = new ArrayList<>();
                allPoker.addAll(handle);
                allPoker.addAll(dipai);
                gamer.setAllHandle(allPoker);
            }
        }
        long l = System.currentTimeMillis();
        //每个人匹配最大牌型
        for (int i = 0; i < peopleNum; i++) {
            JudgmentClass.matchPoker(gamers.get(i));
        }

        //当前最大人
        Gamer gamer = gamers.get(0);
        //最大放如入数组中
        List<Gamer> win = new ArrayList<>();
        win.add(gamer);
        for (int i = 1; i < gamers.size(); i++) {
            Gamer g = gamers.get(i);
            int compare = g.compare(gamer);
            if( compare == 0){
                win.add(gamer);
                continue;
            }
            if(compare == -1){
                continue;
            }
            gamer = g;
            win.clear();
            win.add(gamer);
        }
        long l1 = System.currentTimeMillis();
        /*System.out.println("底牌：" + JSONObject.toJSONString(dipai));
        System.out.println("-----------------------------");

        for (int i = 0; i < gamers.size(); i++) {
            Gamer gamer1 = gamers.get(i);
            System.out.print("id: " + gamer1.getId());
            System.out.print(" 手牌: " + JSONObject.toJSONString(gamer1.getHandle()));
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(JSONObject.toJSONString(gamer1.getFinalHandle()));
            resolveRefs(jsonNode,jsonNode);
            System.out.println("最终手牌 :" + jsonNode.toString());
            System.out.println("牌型 :" + gamer1.getClassEnum().getDesc());
        }
        System.out.println("---------结果-----------");
        for (Gamer gamer1:win){
            System.out.print("id: " + gamer1.getId());
            System.out.print(" 手牌: " + JSONObject.toJSONString(gamer1.getHandle()));
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(JSONObject.toJSONString(gamer1.getFinalHandle()));
            resolveRefs(jsonNode,jsonNode);
            System.out.println("最终手牌 :" + jsonNode.toString());
            System.out.println("牌型 :" + gamer1.getClassEnum().getDesc());
        }*/
        //System.out.println("执行时间：" + (l1- l) + "ms");

        for (Gamer gamer1:gamers){
            if(tj.containsKey(gamer1.getClassEnum().getType())){
                tj.put(gamer1.getClassEnum().getType(),tj.get(gamer1.getClassEnum().getType())+1);
            }else{
                tj.put(gamer1.getClassEnum().getType(),1);
            }
        }
        //ceshi();
    }

    public static void ceshi(){
        Gamer gamer = new Gamer();
        List<Poker> handle  = JSONArray.parseArray("[{\"num\":1,\"sortNum\":14,\"type\":3},{\"num\":3,\"sortNum\":3,\"type\":4}]",Poker.class);
        gamer.setHandle(handle);
        List<Poker> dipai = JSONArray.parseArray("[{\"num\":1,\"sortNum\":14,\"type\":1},{\"num\":13,\"sortNum\":13,\"type\":3},{\"num\":3,\"sortNum\":3,\"type\":2},{\"num\":3,\"sortNum\":3,\"type\":1},{\"num\":13,\"sortNum\":13,\"type\":4}]",Poker.class);
        List<Poker> allPoker = new ArrayList<>();
        allPoker.addAll(handle);
        allPoker.addAll(dipai);
        gamer.setAllHandle(allPoker);
        JudgmentClass.matchPoker(gamer);
        System.out.println(JSONObject.toJSONString(gamer));
    }

    private static void resolveRefs(JsonNode node, JsonNode root) {
        if (node.isObject()) {
            node.fields().forEachRemaining(entry -> {
                JsonNode value = entry.getValue();
                if (value.isObject() && value.has("$ref")) {
                    String refPath = value.get("$ref").asText();
                    JsonNode resolvedValue = resolveRefPath(root, refPath);
                    ((ObjectNode) node).set(entry.getKey(), resolvedValue);
                } else {
                    resolveRefs(value, root);
                }
            });
        } else if (node.isArray()) {
            node.elements().forEachRemaining(element -> resolveRefs(element, root));
        }
    }
    private static JsonNode resolveRefPath(JsonNode root, String refPath) {
        // Split the reference path into segments
        String[] segments = refPath.split("\\.");

        // Traverse the root JSON to find the referenced value
        JsonNode current = root;
        for (String segment : segments) {
            if (segment.startsWith("[")) {
                // Handle array indexing
                int index = Integer.parseInt(segment.substring(1, segment.length() - 1));
                current = current.path(index);
            } else {
                current = current.path(segment);
            }
        }

        return current;
    }
}
