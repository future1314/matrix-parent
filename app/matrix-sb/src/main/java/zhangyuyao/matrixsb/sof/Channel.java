/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.sof;

import java.util.List;

/**
 * @author zyy43688
 * @version $Id: Channel.java, v 0.1 2018年5月31日 下午2:10:01 zyy43688 Exp $
 */
public class Channel {
    /**
     * 消息主题
     */
    private String             topic;

    /**
     * channel事件
     */
    private List<ChannelEvent> events;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public List<ChannelEvent> getEvents() {
        return events;
    }

    public void setEvents(List<ChannelEvent> events) {
        this.events = events;
    }
}