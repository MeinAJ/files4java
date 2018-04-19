package com.aj.common.utils.redis;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

/**
 * this is a class 4 redis
 *
 * @author Administrator
 * @create 2018-02-23 21:48
 */

public class RedisPool {

    //静态redis pool
    private static ShardedJedisPool pool;

    static {
        try {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxWaitMillis(5000);
            config.setMaxTotal(500);
            config.setMaxIdle(100);
            config.setMinIdle(20);
            Properties props = new Properties();
            props.load(RedisPool.class.getClassLoader().getResourceAsStream("redis.properties"));
            JedisShardInfo jedisShardInfo1 = new JedisShardInfo(props.getProperty("redis.host"), Integer.valueOf(props.getProperty("redis.port")));
            jedisShardInfo1.setPassword(props.getProperty("redis.pass"));
            List<JedisShardInfo> list = new LinkedList<JedisShardInfo>();
            list.add(jedisShardInfo1);
            pool = new ShardedJedisPool(config, list);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static ShardedJedis getJedisShardInfo() {
        return pool.getResource();
    }

    public static ShardedJedisPool getShardedJedisPool() {
        return pool;
    }
}
