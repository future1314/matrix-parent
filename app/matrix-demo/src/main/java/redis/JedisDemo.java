package redis;

import redis.clients.jedis.Jedis;

/**
 * 最简单的Jedis客户端连接demo
 */
public class JedisDemo {

    public static void main(String[] args) {

        // 创建Redis客户端
        // host及port都是采用的默认值
        // host: localhost
        // port: 6379
        Jedis jedis = new Jedis();

        jedis.set("message", "hello redis!");

        System.out.println(jedis.get("message"));
    }
}
