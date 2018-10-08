package redis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Protocol;

/**
 * JedisPool的使用
 */
public class JedisPoolDemo {
    public static void main(String[] args) {

        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();

        JedisPool jedisPool = new JedisPool(poolConfig, Protocol.DEFAULT_HOST, Protocol.DEFAULT_PORT);

        Jedis jedis = null;

        try {
            jedis = jedisPool.getResource();

            jedis.set("message", "hello JedisPool");

            System.out.println(jedis.get("message"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {

                // 如果使用了连接池，close并不是关闭连接而是归还连接
                jedis.close();
            }
        }
    }
}
