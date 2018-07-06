/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.sof;

import java.nio.channels.Channels;

/**
 * @author zyy43688
 * @version $Id: ConsumerBean.java, v 0.1 2018年5月31日 上午11:40:56 zyy43688 Exp $
 */
public class ConsumerBean implements ShutdownCallback {

    /**
     * 消费者组
     */
    private String                      group;

    /**
     * 消息命名服务器
     */
    private String                      nameSrvAddress;

    /**
     * 消费方式
     */
    private String                      consumeFromWhere;

    /**
     * 消费模式，点对点、广播
     */
    private String                      messageModel;

    /**
     * 统一消息事件监听器
     */
    private UniformEventMessageListener listener;

    /**
     * 消费者订阅的channel，channel由主题、事件id组成
     */
    private Channels                    channels;

    /**
     * 统一事件订阅器
     */
    private UniformEventSubscriber      uniformEventSubscriber;

    /**
     * 最大消费线程数
     */
    private int                         consumeThreadMax;

    /**
     * 最小消费线程数
     */
    private int                         consumeThreadMin;

    /**
     * 一次拉取消息数
     */
    private int                         pullBatchSize;

    /**
     * 拉取消息间隔时间
     */
    private int                         pullInterval;

    /**
     * 拉取消息阏值
     */
    private int                         pullThresholdForQueue;

    /**
     * 消费者实例名称
     */
    private String                      consumerInstanceName;

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getNameSrvAddress() {
        return nameSrvAddress;
    }

    public void setNameSrvAddress(String nameSrvAddress) {
        this.nameSrvAddress = nameSrvAddress;
    }

    public String getConsumeFromWhere() {
        return consumeFromWhere;
    }

    public void setConsumeFromWhere(String consumeFromWhere) {
        this.consumeFromWhere = consumeFromWhere;
    }

    public String getMessageModel() {
        return messageModel;
    }

    public void setMessageModel(String messageModel) {
        this.messageModel = messageModel;
    }

    public UniformEventMessageListener getListener() {
        return listener;
    }

    public void setListener(UniformEventMessageListener listener) {
        this.listener = listener;
    }

    public Channels getChannels() {
        return channels;
    }

    public void setChannels(Channels channels) {
        this.channels = channels;
    }

    public UniformEventSubscriber getUniformEventSubscriber() {
        return uniformEventSubscriber;
    }

    public void setUniformEventSubscriber(UniformEventSubscriber uniformEventSubscriber) {
        this.uniformEventSubscriber = uniformEventSubscriber;
    }

    public int getConsumeThreadMax() {
        return consumeThreadMax;
    }

    public void setConsumeThreadMax(int consumeThreadMax) {
        this.consumeThreadMax = consumeThreadMax;
    }

    public int getConsumeThreadMin() {
        return consumeThreadMin;
    }

    public void setConsumeThreadMin(int consumeThreadMin) {
        this.consumeThreadMin = consumeThreadMin;
    }

    public int getPullBatchSize() {
        return pullBatchSize;
    }

    public void setPullBatchSize(int pullBatchSize) {
        this.pullBatchSize = pullBatchSize;
    }

    public int getPullInterval() {
        return pullInterval;
    }

    public void setPullInterval(int pullInterval) {
        this.pullInterval = pullInterval;
    }

    public int getPullThresholdForQueue() {
        return pullThresholdForQueue;
    }

    public void setPullThresholdForQueue(int pullThresholdForQueue) {
        this.pullThresholdForQueue = pullThresholdForQueue;
    }

    public String getConsumerInstanceName() {
        return consumerInstanceName;
    }

    public void setConsumerInstanceName(String consumerInstanceName) {
        this.consumerInstanceName = consumerInstanceName;
    }

    /**
     * 在容器销毁前执行前处理操作
     *
     * @param sofContext
     */
    @Override
    public void shutdown(SOFContext sofContext) {
        if (uniformEventSubscriber != null) {
            try {
                uniformEventSubscriber.shutdown();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}