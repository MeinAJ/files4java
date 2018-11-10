package com.example.demo.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import java.io.IOException;
import java.util.Properties;

public class RedisPool {

	private static JedisPool jedisPool = null;

	// 私有化构造方法
	private RedisPool() {
	}

	/**
	 * 静态代码块在类加载时调用，并且只调用一次，静态代码块不能实现懒加载所以此处考虑不使用
	 * 为了实现懒加载，并且不希望每次调用getInstance时都必须互斥执行
	 */
	static {
		try {
			JedisPoolConfig config = new JedisPoolConfig();
			// 表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；
			config.setMaxWaitMillis(5000);
			// 控制一个pool可分配多少个jedis实例，通过pool.getResource()来获取；
			// 如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
			config.setMaxTotal(1000);
			// 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。
			config.setMaxIdle(100);
			// 控制一个pool最少有多少个状态为idle(空闲的)的jedis实例。
			config.setMinIdle(20);
			Properties props = new Properties();
			props.load(RedisPool.class.getClassLoader().getResourceAsStream("redis.properties"));

			// 获取jedisPool
			jedisPool = new JedisPool(config, props.getProperty("redis.host"),
					Integer.valueOf(props.getProperty("redis.port")), 10000, props.getProperty("redis.pass"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static JedisPool getJedisPool() {
		return jedisPool;
	}

	public static Jedis getJedis() {
		return jedisPool.getResource();
	}

	// /**
	// * 同步获取Jedis实例
	// *
	// * @return Jedis
	// */
	// public synchronized static Jedis getJedis() {
	// Jedis jedis = null;
	// try {
	// if (jedisPool != null) {
	// jedis = jedisPool.getResource();
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return jedis;
	// }

}
