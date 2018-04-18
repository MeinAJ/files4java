package com.aj.common.utils.redis;

import com.aj.common.utils.Base;
import redis.clients.jedis.ShardedJedis;

/**
 * this is a util 4 redis
 *
 * @author Administrator
 * @create 2018-02-23 21:48
 */

@SuppressWarnings("static-access")
public class RedisUtil extends Base{

    /**
     * 通过key获取value
     */
    public static Object getKey(String key){
        ShardedJedis jedisShardInfo = RedisPool.getJedisShardInfo();
        String value = "";
        try {
            value = jedisShardInfo.get(key);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            jedisShardInfo.close();
            jedisShardInfo = null;
        }
        return json.parseObject(value);
    }

    // get缓存-转成json
    public static void setKey(String key, Object valueobj, int expire) {
        String value = json.toJSONString(valueobj);
        ShardedJedis jedisShardInfo = RedisPool.getJedisShardInfo();
        try {
            jedisShardInfo.set(key, value);
            if (expire > 0) {
                jedisShardInfo.expire(key, expire * 86400);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedisShardInfo.close();
            jedisShardInfo = null;
        }
    }

    //清除缓存
    public static void removeKey(String key) {
        ShardedJedis jedisShardInfo = RedisPool.getJedisShardInfo();
        try {
            jedisShardInfo.del(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedisShardInfo.close();
            jedisShardInfo = null;
        }
    }

    //设置key,以分钟计算
    public static void setKeyByMinutes(String key, Object value, Integer expire) {
        String result = "";
        ShardedJedis jedisShardInfo = RedisPool.getJedisShardInfo();
        try {
            jedisShardInfo.set(key, json.toJSONString(value), "NX", "EX", expire);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedisShardInfo.close();
            jedisShardInfo = null;
        }
    }
}
