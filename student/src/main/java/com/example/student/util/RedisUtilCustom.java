package com.example.student.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.util.CollectionUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

public class RedisUtilCustom {

   // private RedisTemplate<String, Object> redisTemplate;
    private StringRedisTemplate redisTemplate;
    private JedisPool jedisPool;
    private JedisCluster jedisCluster;


    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }
    public void setRedisTemplate(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
    //=============================common============================


    /*@Autowired(required = false)
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);
        this.redisTemplate = redisTemplate;
    }*/
    //------------------------------------list----------------------------------
    /**
     * kye类型list
     * value类型List<Long>
     * 从左边压入所有值
     *
     * @param key
     * @param value
     * @return
     */
    public boolean leftSetAllTypeLongList(String key, List value) {
        try {
            redisTemplate.opsForList().leftPushAll(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * kye类型list
     * value类型List<Long>
     * 从右边压入所有值
     *
     * @param key
     * @param value
     * @return
     */
    public boolean rightSetAllTypeLongList(String key, List<String> value) {
        try {
            redisTemplate.opsForList().rightPushAll(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * kye类型list
     * value类型Long
     * 从左边压入一个值值
     *
     * @param key
     * @param value
     * @return
     */
    public boolean leftSetTypeLongList(String key, String value) {
        try {
            redisTemplate.opsForList().leftPush(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * kye类型list
     * value类型Long
     * 删除一个value
     *
     * @param key
     * @param value
     * @return
     */
    public boolean deleteValueTypeList(String key, String value) {
        try {
            redisTemplate.opsForList().remove(key,1,value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取list缓存的内容
     * @param key 键
     * @param start 开始
     * @param end 结束  0 到 -1代表所有值
     * @return
     */
    public List<String> getTypeList(String key,int start, int end){
        try {
            return redisTemplate.opsForList().range(key, start, end);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //------------------------------------hash----------------------------------

    /**
     * type hash
     * 批量导入map
     * @param key
     * @param value
     * @return
     */
    public boolean hashSetMapTypeHash(String key,Map<String,String> value){
        try {
            redisTemplate.opsForHash().putAll(key,value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * type hash
     * key查询一个keyValue的值
     * @param key
     * @param value
     * @return
     */
    public Object getHashMapTypeHash(String key,String value){
        try {
            Object o = redisTemplate.opsForHash().get(key, value);
            return o;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * type hash
     * key查询多个keyValue的值
     * @param key
     * @param value
     * @return
     */
    public List<Object> mGetHashMapListTypeHash(String key,Collection<Object> value){
        try {
            List<Object> objects = redisTemplate.opsForHash().multiGet(key, value);
            return objects;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * type hash
     * 删除key下的对应value key的值
     * @param key
     * @param value
     * @return
     */
    public boolean deleteValueTypeHash(String key,String value){
        try {
            redisTemplate.opsForHash().delete(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     * type string
     * 批量存入
     *
     */
    public  boolean msetTypeString(Map<String,String> map){
        try {
            redisTemplate.opsForValue().multiSet(map);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * type string
     * 批量获取
     */
    public List<String> mgetTypeString(Collection<String> keys){
        try {
            List<String> values = redisTemplate.opsForValue().multiGet(keys);
            return values;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * type string
     * 批量删除
     */
    public boolean deleteListTypeString(Collection<String> value){
        try {
            redisTemplate.delete(value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * type string
     * 删除一个
     */
    public boolean deleteTypeString(String key){
        try {
            redisTemplate.delete(key);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * type String
     * 修改一个key
     */
    public boolean updateTypeString(String key,String value){
        try {
            redisTemplate.opsForValue().set(key,value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String set(String key, String value, String nxxx, String expx, long time) {
        return jedisCluster.set(key, value, nxxx, expx, time);
    }

    public Object eval(String script, List<String> keys, List<String> args) {
        return jedisCluster.eval(script, keys, args);
    }

}
