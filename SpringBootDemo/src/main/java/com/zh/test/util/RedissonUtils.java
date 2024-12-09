package com.zh.test.util;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
@Component
public class RedissonUtils {

    @Autowired
    RedissonClient redissonClient;

    private static final String LOCK_TITLE = "redisLock_";

    public void getLock(String key,Integer time) {
        RLock lock = redissonClient.getLock(LOCK_TITLE+key);
        lock.lock(time, TimeUnit.SECONDS);
    }

    public void unLock(String key) {
        RLock lock = redissonClient.getLock(LOCK_TITLE+key);
        lock.unlock();
    }
}
