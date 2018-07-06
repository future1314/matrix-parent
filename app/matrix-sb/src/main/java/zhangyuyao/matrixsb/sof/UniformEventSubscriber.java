/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.sof;

/**
 * 统一消息事件订阅者
 *
 * @author zyy43688
 * @version $Id: UniformEventSubscriber.java, v 0.1 2018年5月31日 下午2:16:29 zyy43688 Exp $
 */
public interface UniformEventSubscriber extends BaseUniformEventProcessor {

    /**
     * 获取从队列哪里开始消费
     * 
     * @return
     */
    ConsumeFromWhere getConsumeFromWhere();

    /**
     * 获取消息模型
     * 
     * @return
     */
    MessageModel getMessageModel();

    /**
     * 注册统一消息事件监听器
     * 
     * @param listener
     */
    void registerUniformEventMessageListener(UniformEventMessageListener listener);

    /**
     * 订阅
     * 
     * @param topic
     * @param eventId
     */
    void subscribe(final String topic, final String eventId);

    /**
     * 订阅
     * 
     * @param topic
     * @param fullClassName
     * @param filterClassSource
     */
    void subscribe(final String topic, final String fullClassName, final String filterClassSource);

    /**
     * 恢复
     */
    void resume();

    /**
     * 挂起
     */
    void suspend();
}