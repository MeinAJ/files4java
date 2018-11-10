package com.example.demo.utils;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

@Component(value = "redisUtil")
public class RedisUtil {

    /**
     * 获取分布式锁
     */
    public Integer getNXKey(String key,Integer expire){

        Jedis jedis = RedisPool.getJedis();
        try {
            Long setnx = jedis.setnx(key, String.valueOf(System.currentTimeMillis() + expire * 1000));
            if (setnx != 1){
                /**
                 * 获取锁,看是否已经过期
                 */
                String oldTimeStamp = jedis.get(key);
                if (Long.parseLong(oldTimeStamp) < System.currentTimeMillis()){
                    //已经过期,如果可以获取
                    String currentExpireTime = jedis.getSet(key, String.valueOf(System.currentTimeMillis() + expire * 1000));
                    if (oldTimeStamp.equals(currentExpireTime)){
                        return 1;
                    }
                }
            } else {
                /**
                 * 获取锁成功,直接返回1
                 */
                return 1;
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (jedis != null){
                jedis.close();
            }
        }
        return 0;
    }


    /**
     * 释放分布式锁
     */
    public Integer releaseKey(String key){
        Jedis jedis = RedisPool.getJedis();
        try {
            if (key != null){
                jedis.del(key);
                return 1;
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (jedis != null){
                jedis.close();
            }
        }
        return 0;
    }

}
