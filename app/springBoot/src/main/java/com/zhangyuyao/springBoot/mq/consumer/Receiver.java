package com.zhangyuyao.springBoot.mq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息接收者
 *
 * @author 张玉尧（matrix.zhang@ximalaya.com）
 * @version $Id: Receiver.java, v 0.1 2018年9月3日 下午3:48:04 张玉尧（matrix.zhang@ximalaya.com） Exp $
 */
@Component
@RabbitListener(queues = "hello")
public class Receiver {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver: " + hello);
    }
}
