/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.cache.lock;

import java.util.Arrays;
import java.util.Collections;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * redis 实现分布式锁
 * 
 * 锁的四个基本特性：
 *  互斥性
 *  防死锁（客户端奔溃之后能够正确的释放锁，解决方案是给锁设置超时时间）
 *  解铃还须系铃人
 *  容错性
 * @author zyy43688
 * @version $Id: RedisLockDemo.java, v 0.1 2018年6月14日 下午4:34:27 zyy43688 Exp $
 */
@Slf4j
public class RedisLockDemo {

    /**
     * 连接池
     */
    private final static JedisPool jedisPool;

    /**
     * 主机
     */
    private static final String    host = "localhost";

    /**
     * 端口
     */
    private static final int       port = 6379;

    static {
        jedisPool = new JedisPool(host, port);
    }

    public static void main(String[] args) {
        Jedis jedis = jedisPool.getResource();
        log.info("{}", Arrays.toString(jedis.keys("*").toArray()));
    }

    private static final String LOCK_SUCCESS         = "OK";
    private static final String SET_IF_NOT_EXIST     = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";

    /**
     * 尝试获取分布式锁
     * @param jedis Redis客户端
     * @param lockKey 锁
     * @param requestId 请求标识
     * @param expireTime 超期时间
     * @return 是否获取成功
     */
    public static boolean tryGetDistributedLock(Jedis jedis, String lockKey, String requestId, int expireTime) {

        String result = jedis.set(lockKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);

        if (LOCK_SUCCESS.equals(result)) {
            return true;
        }

        return false;

    }

    private static final Long RELEASE_SUCCESS = 1L;

    /**
     * 释放分布式锁
     * @param jedis Redis客户端
     * @param lockKey 锁
     * @param requestId 请求标识
     * @return 是否释放成功
     */
    public static boolean releaseDistributedLock(Jedis jedis, String lockKey, String requestId) {

        // lua 脚本代码（保证操作的原子性）
        // 逻辑非常简单
        //  首先判断是否是持有锁的客户端
        //  是：删除锁（释放锁）
        //  否：返回删除失败
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));

        if (RELEASE_SUCCESS.equals(result)) {
            return true;
        }
        return false;

    }
}