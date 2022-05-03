package com.example.student.project.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.student.project.dao.EcpmGrayMapper;
import com.example.student.project.domain.EcpmGray;
import com.example.student.project.service.EcpmService;
import com.example.student.util.RedisUtil;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description: EcpmServiceImpl
 * @date: 2021/8/17 下午5:14
 * @author: zcy
 * @version: 1.0
 */
@Service
public class EcpmServiceImpl implements EcpmService {
    @Autowired
    private EcpmGrayMapper ecpmGrayMapper;

    @Override
    public List<EcpmGray> select() {
        List<EcpmGray> select = ecpmGrayMapper.select();
        List<EcpmGray> ecpmGrays = Lists.newArrayList();
        List<Long> userIds = Lists.newArrayList();
        int index = 0;
        for (EcpmGray ecpmGray : select) {
            String value = ecpmGray.getValue();
            String[] split = value.split(":");
            long l = Long.parseLong(split[split.length - 1]);
            if (l < 500000) {
                EcpmGray ecpmGray1 = new EcpmGray();
                ecpmGray1.setUserId(ecpmGray.getUserId());
                ecpmGray1.setValue(ecpmGray.getValue());
                ecpmGray1.setEcpm(l);
                ecpmGrays.add(ecpmGray1);
                userIds.add(ecpmGray1.getUserId());
            }
        }
        System.out.println(JSONObject.toJSONString(userIds));
        System.out.println(ecpmGrays.size());
        System.out.println(index);
        return ecpmGrays;
    }

    private void deal(List<EcpmGray> ecpmGrays) {
        RedisUtil redisUtil = new RedisUtil();
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(30);
        config.setMaxIdle(2);
        Set<HostAndPort> jedisClusterNode = new HashSet<HostAndPort>();
        //wdfd
        jedisClusterNode.add(new HostAndPort("172.16.41.10", 9720));
        //jedisClusterNode.add(new HostAndPort("172.16.11.191", 9720));
        //jedisClusterNode.add(new HostAndPort("172.16.11.193", 9720));
        JedisCluster jcd = new JedisCluster(jedisClusterNode, config);
        long userId = 202711478;
        long but = userId % 8;
        String mGray = jcd.hget("yydxny:u:msg:"+userId, "mGray");
        Long sadd = jcd.sadd("yydxny:g:op:u:08172000:" + but, userId + "");
        System.out.println(JSONObject.toJSONString(mGray));
        System.out.println(sadd);
        try {
            jcd.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void delRedis() {
        RedisUtil redisUtil = new RedisUtil();
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(30);
        config.setMaxIdle(2);
        Set<HostAndPort> jedisClusterNode = new HashSet<HostAndPort>();
        //wdfd
        jedisClusterNode.add(new HostAndPort("172.16.41.10", 9720));
        //jedisClusterNode.add(new HostAndPort("172.16.11.191", 9720));
        //jedisClusterNode.add(new HostAndPort("172.16.11.193", 9720));
        JedisCluster jcd = new JedisCluster(jedisClusterNode, config);
        String mGray = jcd.hget("yydxny:u:msg:202711478", "mGray");
        System.out.println(JSONObject.toJSONString(mGray));
        try {
            jcd.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
