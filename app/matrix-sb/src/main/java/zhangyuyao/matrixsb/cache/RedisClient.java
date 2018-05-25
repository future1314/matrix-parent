/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.cache;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author zyy43688
 * @version $Id: RedisClient.java, v 0.1 2018年5月17日 下午7:23:19 zyy43688 Exp $
 */

// http://redis.cn/
@Component
public class RedisClient {

    @Resource(name = "redisPool")
    private JedisPool jedisPool;

    /**
     * 
     * @param key
     * @param value
     */
    public void set(String key, String value) {
        Jedis jedis = null;

        try {
            jedis = jedisPool.getResource();

            jedis.set(key, value);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 
     * @param key
     * @return
     */
    public String get(String key) {
        Jedis jedis = null;

        try {
            jedis = jedisPool.getResource();

            return jedis.get(key);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
}