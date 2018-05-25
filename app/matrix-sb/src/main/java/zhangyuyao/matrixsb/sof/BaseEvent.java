/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.sof;

import java.util.EventObject;

/**
 * SOF基础时间模型
 *
 * @author zyy43688
 * @version $Id: BaseEvent.java, v 0.1 2018年5月21日 下午5:23:10 zyy43688 Exp $
 */
public abstract class BaseEvent extends EventObject {

    /**  */
    private static final long serialVersionUID = 1L;

    /**
     * 事件id
     */
    private final String      id;

    /**
     * 事件产生的时间戳
     */
    private final long        timestamp;

    /**
     * 构造函数
     * 
     * @param source 产生事件的事件源
     * @param id 事件ID
     */
    public BaseEvent(Object source, String id) {
        super(source);
        this.id = id;
        this.timestamp = System.currentTimeMillis();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "BaseEvent [id=" + id + ", timestamp=" + timestamp + "]";
    }
}