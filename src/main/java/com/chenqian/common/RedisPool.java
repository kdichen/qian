package com.chenqian.common;

import com.chenqian.util.PropertiesUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Author: 陈谦
 * @Date: 2018/5/23 21:35
 */

public class RedisPool {
    /**
     * jedis 连接池
     */
    private static JedisPool pool;
    /**
     * 最大连接数
     */
    private static Integer maxTotal = Integer.parseInt(PropertiesUtil.getProperty("redis.max.total", "20"));
    /**
     * 在jedispool中最大的idle状态(空闲的)的 jedis 实例的个数
     */
    private static Integer maxIdle = Integer.parseInt(PropertiesUtil.getProperty("redis.max.idle", "20"));
    /**
     * 在 jedispool 中最小的idle状态(空闲的)的 jedis 实例的个数
     */
    private static Integer minIdle = Integer.parseInt(PropertiesUtil.getProperty("redis.min.idle", "20"));
    /**
     * 在borrow一个 jedis 实例的时候，是否要进行验证操作，如果赋值 true。则得到的 jedis 实例肯定是可以用的。
     */
    private static Boolean testOnBorrow = Boolean.parseBoolean(PropertiesUtil.getProperty("redis.test.borrow", "true"));
    /**
     * 在return一个 jedis 实例的时候，是否要进行验证操作，如果赋值true。则放回 jedispool 的 jedis 实例肯定是可以用的。
     */
    private static Boolean testOnReturn = Boolean.parseBoolean(PropertiesUtil.getProperty("redis.test.return", "true"));

    private static String redisIp = PropertiesUtil.getProperty("redis.ip");
    private static Integer redisPort = Integer.parseInt(PropertiesUtil.getProperty("redis.port"));

    /**
     * 初始化连接池, 为了保证不被其他人调用, 设置成private
     */
    private static void initPool() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(maxTotal);
        config.setMaxIdle(maxIdle);
        config.setMinIdle(minIdle);

        config.setTestOnBorrow(testOnBorrow);
        config.setTestOnReturn(testOnReturn);
        // 连接耗尽的时候，是否阻塞，false会抛出异常，true阻塞直到超时。默认为true。
        config.setBlockWhenExhausted(true);
        // 初始化 IP 端口 超时时间
        pool = new JedisPool(config, redisIp, redisPort, 1000 * 2);
    }

    static {
        initPool();
    }

    public static Jedis getJedis() {
        return pool.getResource();
    }

    /**
     * 正常连接jedis 源码有判断是否为空
     *
     * @param jedis
     */
    public static void returnResource(Jedis jedis) {
        pool.returnResource(jedis);
    }

    /**
     * 损坏的连接 源码有判断是否为空
     *
     * @param jedis
     */
    public static void returnBrokenResource(Jedis jedis) {
        pool.returnBrokenResource(jedis);
    }

    public static void main(String[] args) {
        Jedis jedis = pool.getResource();
        jedis.set("chen", "qian");
        returnResource(jedis);
        // 销毁连接池中所有的连接(练习使用, 实际开发不会手动销毁)
        pool.destroy();
        System.out.println("连接完成");
    }
}
