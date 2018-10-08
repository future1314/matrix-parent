package zhangyuyao.matrixsb.redis;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 *
 */
@Configuration
@Slf4j
public class Redis {

    /**
     * 配置连接工厂
     *
     * @param redisStandaloneConfiguration
     * @return
     */
    @Bean
    public RedisConnectionFactory redisConnectionFactory(@Qualifier("redisStandaloneConfiguration1") RedisStandaloneConfiguration redisStandaloneConfiguration) {
        log.info("实际的bean: {}", new Gson().toJson(redisStandaloneConfiguration));
        return new JedisConnectionFactory(redisStandaloneConfiguration);
    }

    /**
     * Redis连接配置
     *
     * @return
     */
    @Bean
    @Profile("dev")
    public RedisStandaloneConfiguration redisStandaloneConfiguration() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();

        redisStandaloneConfiguration.setHostName("localhost");
        redisStandaloneConfiguration.setPort(6379);
        redisStandaloneConfiguration.setDatabase(1);
//        redisStandaloneConfiguration.setPassword();

        log.info("dev 环境被激活！");
        log.info("{}", new Gson().toJson(redisStandaloneConfiguration));

        return redisStandaloneConfiguration;
    }

    /**
     * Redis连接配置
     *
     * @return
     */
    @Bean
    @Profile("test")
    public RedisStandaloneConfiguration redisStandaloneConfiguration1() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();

        redisStandaloneConfiguration.setHostName("localhost");
        redisStandaloneConfiguration.setPort(6379);
        redisStandaloneConfiguration.setDatabase(0);

        log.info("test 环境被激活！");
        log.info("{}", new Gson().toJson(redisStandaloneConfiguration));

        return redisStandaloneConfiguration;
    }

    /**
     * 模板
     *
     * @param redisConnectionFactory
     * @return
     */
//    @Bean("myRedisTemplate")
//    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
//        return new StringRedisTemplate(redisConnectionFactory);
//    }

    @Bean("myRedisTemplate")
    @Conditional(RedisConditional.class)
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory redisConnectionFactory) {

        log.info("验证conditional");

        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();

        redisTemplate.setConnectionFactory(redisConnectionFactory);

        return redisTemplate;
    }
}
