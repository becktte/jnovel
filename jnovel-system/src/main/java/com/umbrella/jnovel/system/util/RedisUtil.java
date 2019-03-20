package com.umbrella.jnovel.system.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 对redisTemplate的封装
 * @author yeyongjian
 */
@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public RedisTemplate getInstance() {
        return this.redisTemplate;
    }

    public Boolean exist(String key) {
        return redisTemplate.hasKey(key);
    }

    public Boolean set(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean set(String key, Object value, long timeout) {
        try {
            redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean set(String key, Object value, long timeout, TimeUnit unit) {
        try {
            redisTemplate.opsForValue().set(key, value, timeout, unit);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public Boolean expire(String key, long timeout) {
        return redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
    }

    public Boolean expire(String key, long timeout, TimeUnit unit) {
        return redisTemplate.expire(key, timeout, unit);
    }

    public Boolean delete(String key) {
        return redisTemplate.delete(key);
    }

    public Long delete(List<String> keys) {
        return redisTemplate.delete(keys);
    }

    public long incr(String key) {
        return redisTemplate.opsForValue().increment(key);
    }

    public long incr(String key, long delta) {
        return redisTemplate.opsForValue().increment(key, delta);
    }

    public long decr(String key) {
        return redisTemplate.opsForValue().decrement(key);
    }

    public long decr(String key, long delta) {
        return redisTemplate.opsForValue().decrement(key, delta);
    }

    public Boolean hmset(String key, Map<Object, Object> map) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Map<Object, Object> hmget(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    public Object hget(String key, Object hashKey) {
        return redisTemplate.opsForHash().get(key, hashKey);
    }

    public Boolean hset(String key, Object hashkey, Object value) {
        try {
            redisTemplate.opsForHash().put(key, hashkey, value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void hdel(String key, Object... hashkey) {
        redisTemplate.opsForHash().delete(key, hashkey);
    }

    public Boolean hmexist(String key, String hashkey) {
        return redisTemplate.opsForHash().hasKey(key, hashkey);
    }

    public Boolean setnx(String key, Object value) {
        return redisTemplate.opsForValue().setIfAbsent(key, value);
    }

    public Boolean setnx(String key, Object value, long timeout) {
        return redisTemplate.opsForValue().setIfAbsent(key, value, timeout, TimeUnit.SECONDS);
    }

}
