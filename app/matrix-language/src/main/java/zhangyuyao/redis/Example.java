package zhangyuyao.redis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Arrays;

/**
 * @author 张玉尧（matrix.zhang@ximalaya.com）
 * @version $Id: Example.java, v 0.1 2018年9月21日 下午6:04:07 张玉尧（matrix.zhang@ximalaya.com） Exp $
 */
public class Example {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:RedisLearn.xml");

        RedisTemplate<String, String> redisTemplate = (RedisTemplate<String, String>) context.getBean("redisTemplate");

        System.out.println(Arrays.toString(redisTemplate.keys("*").toArray()));
        System.out.println(redisTemplate.hasKey("test"));
        BoundSetOperations<String, String> operations = redisTemplate.boundSetOps("name");
        operations.add("zhangyuyao");
    }
}
