/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.sof;

import java.util.Map;

/**
 * 统一事件模型，封装消息中间件的消息载体
 *
 * @author zyy43688
 * @version $Id: UniformEvent.java, v 0.1 2018年5月22日 下午6:40:42 zyy43688 Exp $
 */
public interface UniformEvent extends Identifiable<String> {
    /**
     * 事物消息分组后缀
     */
    String TX_GROUP_SUFFIX = "_tx";

    /**
     * 序列化方式
     */
    String SERIALIZATION   = "sof_serialization";

    /**
     * 事件ID
     */
    String EVENT_ID        = "sof_event_id";

    /**
     * 指定消费者IP
     */
    String TARGET_IP       = "sof_target_ip";

    /**
     * 获取主题
     * @return
     */
    String getTopic();

    /**
     * 获取事件码
     * @return
     */
    String getEventCode();

    /**
     * 设置消息载体
     * @param payload
     */
    void setPayload(Object payload);

    /**
     * 获取消息载体
     * @return
     */
    Object getPayload();

    /**
     * 添加用户级属性
     * @param propKey
     * @param propVal
     */
    void addProperty(String propKey, String propVal);

    /**
     * 删除用户级属性
     * @param propKey
     */
    void removePeoperty(String propKey);

    /**
     * 添加用户级属性
     *
     * @param properties
     */
    void addProperties(Map<String, String> properties);

    /**
     * 获取用户级属性
     * @param key
     * @return
     */
    String getProperty(String key);

    /**
     * 获取用户级属性
     * @return
     */
    Map<String, String> getProperties();

    /**
     * 设置是否是事物级属性
     * @param transactional
     */
    void setTransaction(boolean transactional);

    /**
     * 设置序列化方式
     *
     * @param serialize
     */
    void setSerialization(SerializeEnum serialize);

    /**
     * 获取序列化方式
     *
     * @return
     */
    SerializeEnum getSerialize();

    /**
     * 设置发送超时时间
     *
     * @param timeout
     */
    void setTimeout(long timeout);

    /**
     * 获取发送超时时间
     *
     * @return
     */
    long getTimeout();

    /**
     * 设置回调方法，仅同步方式有效
     *
     * @param callback
     */
    void setSendCallback(SendCallback callback);

    /**
     * 获取回调方法，仅同步方式有效
     * @return
     */
    SendCallback getSendCallback();

    /**
     * 是否是事务性消息
     *
     * @return
     */
    boolean isTransactional();

    /**
     * 获取TransactionModel
     * @return
     */
    TransactionModel getTransactionModel();

    /**
     * 设置TransactionModel
     * @param transactionModel
     */
    void setTransactionModel(TransactionModel transactionModel);

    /**
     * 获取MQ原生消息
     * 
     * @return
     */
    Message getMessage();

    /**
     * 设置原生消息
     */
    void setMessage(Message message);

    /**
     * 设置延时消息等级
     * 
     * @param level
     */
    void setDelayTimeLevel(int level);

    /**
     * 获取延时消息等级
     * 
     * @return
     */
    int getDelayTimeLevel();
}