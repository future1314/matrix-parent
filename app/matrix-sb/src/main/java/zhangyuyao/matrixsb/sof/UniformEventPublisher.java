/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.sof;

/**
 * 
 * 统一事件发送器
 * 
 * @author zyy43688
 * @version $Id: UniformEventPublisher.java, v 0.1 2018年5月22日 下午5:37:10 zyy43688 Exp $
 */
public interface UniformEventPublisher extends BaseUniformEventProcessor {
    /**
     * 发布统一消息事件
     *
     * @param event
     * @return
     */
    boolean publishUniformEvent(UniformEvent event);

    /**
     * 发布统一消息事件（oneway方式）
     * 
     * @param event
     * @return
     */
    boolean publishUniformEventOneway(UniformEvent event);

    /**
     * 创建统一消息事件
     * 
     * @param topic
     * @param eventCode
     * @return
     */
    UniformEvent createUniformEvent(String topic, String eventCode);

    /**
     * 创建统一消息事件
     * 
     * @param topic
     * @param eventCode
     * @param transaction
     * @return
     */
    UniformEvent createUniformEvent(String topic, String eventCode, boolean transaction);

    /**
     * 创建统一消息事件
     * 
     * @param topic
     * @param eventCode
     * @param transaction
     * @param payload
     * @return
     */
    UniformEvent createUniformEvent(String topic, String eventCode, boolean transaction, Object payload);
}