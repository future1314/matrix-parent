package com.zhangyuyao.springBoot.mq.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author 张玉尧（matrix.zhang@ximalaya.com）
 * @version $Id: Sender.java, v 0.1 2018年9月3日 下午3:44:43 张玉尧（matrix.zhang@ximalaya.com） Exp $
 */

@Component
public class Sender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    /**
     * 发送消息
     */
    public void send() {
        String context = "hello " + new Date();

        System.out.println("Sender: " + context);

        this.rabbitTemplate.convertAndSend("hello", context);
    }
}
