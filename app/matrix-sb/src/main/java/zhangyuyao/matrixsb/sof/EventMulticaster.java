/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.sof;

import java.util.Collection;

/**
 * @author zyy43688
 * @version $Id: EventMulticaster.java, v 0.1 2018年5月21日 下午5:50:21 zyy43688 Exp $
 */
public interface EventMulticaster {
    /**
     * 注册事件监听器
     */
    void addListener(BaseListener<BaseEvent> listener);

    /**
     * 注销事件监听器
     * 
     * @param listener
     */
    void removeListener(BaseListener<BaseEvent> listener);

    /**
     * 注销所有事件监听器
     */
    void removeAllListeners();

    /**
     * 获取所有注册的事件监听器
     * 
     * @return
     */
    Collection<BaseListener<BaseEvent>> getAllListeners();

    /**
     * 获取所有注册支持该事件的事件监听器
     * 
     * @param event
     * @return
     */
    Collection<BaseListener<BaseEvent>> getAllListeners(BaseEvent event);

    /**
     * 广播事件
     * 
     * @param event 事件
     * @param sync 同步或异步广播
     */
    void multicastEvent(BaseEvent event, boolean sync);
}