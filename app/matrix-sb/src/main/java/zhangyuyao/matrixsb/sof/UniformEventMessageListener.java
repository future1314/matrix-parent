/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.sof;

/**
 * 统一消息事件监听器
 * 
 * @author zyy43688
 * @version $Id: UniformEventMessageListener.java, v 0.1 2018年5月31日 下午1:55:29 zyy43688 Exp $
 */
public interface UniformEventMessageListener {

    /**
     * 消息统一消息事件，如果MQ发送的消息体中，不能找到序列化类型，则默认将二进制数据直接返回出来
     * 
     * @param event 统一消息事件
     * @param context 统一消息事件上下文
     * @return 是否成功消费
     */
    boolean onUniformEvent(UniformEvent event, UniformEventContext context);

    /**
     * 获取监听器类型
     * 
     * @return
     */
    ListenerTypeEnum getListenerType();

    /**
     * 对应RocketMQ的MessageListenerConcurrently和MessageListenerOrderly两种监听器类型
     */
    enum ListenerTypeEnum {
                           CONCURRENTLY, ORDERLY
    }
}