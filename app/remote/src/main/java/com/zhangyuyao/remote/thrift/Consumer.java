package com.zhangyuyao.remote.thrift;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 张玉尧（matrix.zhang@ximalaya.com）
 * @version $Id: Consumer.java, v 0.1 2018年9月3日 下午6:22:24 张玉尧（matrix.zhang@ximalaya.com） Exp $
 */
@Component
@RabbitListener(queues = "test_queue")
public class Consumer {

    @RabbitHandler
    public void test(String msg) {
        System.out.println(msg);
    }
}
