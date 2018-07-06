/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.sof;

/**
 * 统一消息事件订阅者默认实现
 * 
 * @author zyy43688
 * @version $Id: DefaultUniformEventSubscriber.java, v 0.1 2018年5月31日 下午3:03:57 zyy43688 Exp $
 */
public class DefaultUniformEventSubscriber implements UniformEventSubscriber {



    /**
     * 获取从队列哪里开始消费
     *
     * @return
     */
    @Override
    public ConsumeFromWhere getConsumeFromWhere() {
        return null;
    }

    /**
     * 获取消息模型
     *
     * @return
     */
    @Override
    public MessageModel getMessageModel() {
        return null;
    }

    /**
     * 注册统一消息事件监听器
     *
     * @param listener
     */
    @Override
    public void registerUniformEventMessageListener(UniformEventMessageListener listener) {

    }

    /**
     * 订阅
     *
     * @param topic
     * @param eventId
     */
    @Override
    public void subscribe(String topic, String eventId) {

    }

    /**
     * 订阅
     *
     * @param topic
     * @param fullClassName
     * @param filterClassSource
     */
    @Override
    public void subscribe(String topic, String fullClassName, String filterClassSource) {

    }

    /**
     * 恢复
     */
    @Override
    public void resume() {

    }

    /**
     * 挂起
     */
    @Override
    public void suspend() {

    }

    /**
     * 启动统一消息处理器
     */
    @Override
    public void start() {

    }

    /**
     * 停止统一消息处理器
     */
    @Override
    public void shutdown() {

    }

    /**
     * 获取消息分组
     *
     * @return
     */
    @Override
    public String getGroup() {
        return null;
    }

    /**
     * 获取命名服务器
     *
     * @return
     */
    @Override
    public String getNameSrvAddress() {
        return null;
    }
}