package com.example.student.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * @program: walk
 * @description: redisLock
 * @author: bianxuefeng
 * @create: 2019-11-25 11:54
 **/
@Component
@Slf4j
public class RedisLockManger {

    private static final String LOCK_SUCCESS = "OK";

    private static final Long RELEASE_SUCCESS = 1L;

    private static final int DEFAULT_EXPIRY_TIME_MILLIS = 100;

    private static final int DEFAULT_ACQUIRY_RESOLUTION_MILLIS = 10;

    /*@Autowired
    @Qualifier("roadJedisClusterClient")
    private JedisClusterClient roadJedisClusterClient;*/

    /**
     * redis实时获取锁
     *
     * @param lockKey
     * @param requestId
     * @param expireTime
     * @return
     */
    /*public Boolean lock(final String lockKey, final String requestId, final int expireTime) {
        String val = roadJedisClusterClient.set(lockKey, requestId, "nx", "ex", expireTime);
        return LOCK_SUCCESS.equals(val);
    }*/

    /**
     * redis释放锁
     *
     * @param lockKey
     * @param requestId
     * @return
     */
    /*public Boolean releaseLock(final String lockKey, final String requestId) {
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then redis.call('del', KEYS[1]) else return 0 end";
        Object result = roadJedisClusterClient.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));
        return RELEASE_SUCCESS.equals(result);
    }*/

    /**
     * redis 尝试获取锁（cas自旋锁）
     *
     * @param lockKey
     * @param requestId
     * @param expireTime
     * @return
     */
    /*public Boolean tryLock(String lockKey, String requestId, int expireTime) {
        int timeOut = DEFAULT_EXPIRY_TIME_MILLIS;
        try {
            while (timeOut > 0) {
                if (lock(lockKey, requestId, expireTime)) {
                    return true;
                }
                Thread.sleep(DEFAULT_ACQUIRY_RESOLUTION_MILLIS);
                timeOut -= DEFAULT_ACQUIRY_RESOLUTION_MILLIS;
            }
        } catch (Exception e) {
            log.error("redis tryLock exception fail lockKey:{}, requestId:{}, expireTime:{}", lockKey, requestId, expireTime);
            return false;
        }
        log.warn("redis tryLock fail lockKey:{}, requestId:{}, expireTime:{}", lockKey, requestId, expireTime);
        return false;
    }*/
}
