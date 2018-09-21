package com.zhangyuyao.springBoot.mq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Rabbit MQ配置
 *
 * @author 张玉尧（matrix.zhang@ximalaya.com）
 * @version $Id: RabbitConfig.java, v 0.1 2018年9月3日 下午3:40:58 张玉尧（matrix.zhang@ximalaya.com） Exp $
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue helloQueue() {
        return new Queue("hello");
    }
}
