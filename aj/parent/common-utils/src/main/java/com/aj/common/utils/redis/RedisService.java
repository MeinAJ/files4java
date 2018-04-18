package com.aj.common.utils.redis;


import org.springframework.stereotype.Service;

/**
 * this is a service
 *
 * @author Administrator
 * @create 2018-02-24 22:47
 */

@Service("redisService")
public class RedisService{

    // get缓存-value为json存储
    public Object getKey(String key) {
        return RedisUtil.getKey(key);
    }

    // set缓存-value为json存储
    public void setKey(String key, Object value, int expire) {
        RedisUtil.setKey(key, value, expire);
    }

    // set缓存-value为json存储
    public void removeKey(String key) {
        RedisUtil.removeKey(key);
    }

    // set缓存-value为json存储,以分钟计算
    public void setKeyByMinutes(String key,Object value,Integer minutes) {
        RedisUtil.setKeyByMinutes(key,value,minutes);
    }
}
