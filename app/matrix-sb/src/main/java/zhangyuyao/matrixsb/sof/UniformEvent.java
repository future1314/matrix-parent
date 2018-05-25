/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.sof;

import java.util.Map;

/**
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

    String getTopic();

    String getEventCode();

    void setPayload(Object payload);

    Object getPayload();

    void addProperty(String propKey, String propVal);

    void removePeoperty(String propKey);

    void addProperties(Map<String, String> properties);

    String getProperty(String key);

    Map<String, String> getProperties();

    void setTransaction(boolean transactional);

    void setSerialization(SerializeEnum serialize);

    SerializeEnum getSerialize();

    void setTimeout(long timeout);

    long getTimeout();

    void setSendCallback(SendCallback callback);

    SendCallback getSendCallback();

    boolean isTransactional();


}