package zhangyuyao.matrixsb.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RedisController {

    @Resource
    @Qualifier("myRedisTemplate")
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/redis/set")
    public void set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    @GetMapping("/redis/get")
    @ResponseBody
    public String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }
}
