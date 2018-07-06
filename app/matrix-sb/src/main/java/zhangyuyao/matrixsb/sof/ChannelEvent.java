/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.sof;

/**
 * 频道事件
 * 
 * @author zyy43688
 * @version $Id: ChannelEvent.java, v 0.1 2018年5月31日 下午2:10:24 zyy43688 Exp $
 */
public class ChannelEvent {
    /**
     * 事件码
     */
    private String eventCode;

    /**
     * 事件类型，保留字段，目前未使用
     */
    private String eventType;

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
}