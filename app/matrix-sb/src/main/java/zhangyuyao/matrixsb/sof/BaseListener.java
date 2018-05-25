/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.sof;

import java.util.EventListener;

/**
 * @author zyy43688
 * @version $Id: BaseListener.java, v 0.1 2018年5月21日 下午5:28:58 zyy43688 Exp $
 */
public interface BaseListener<E extends BaseEvent> extends EventListener {

    /**
     * 事件处理器
     * 
     * @param event 事件
     */
    void onEvent(E event);

    /**
     * 是否支持处理该事件类型
     * 
     * @param event 事件
     * @return
     */
    boolean isSupportEvent(BaseEvent event);
}