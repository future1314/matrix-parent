/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.sof;

/**
 * 
 * 事件监听器注册接口，系统扫描容器中所有实现了{@link BaseListener}接口的实现类，并注册这些监听器，
 * 
 * @author zyy43688
 * @version $Id: ListenerRegister.java, v 0.1 2018年5月21日 下午5:20:03 zyy43688 Exp $
 */
public interface ListenerRegister {

    /**
     * 注册容器中的监听器
     */
    void registerListener();

    /**
     * 注册监听器
     * 
     * @param listener 监听器
     */
    void registerListener(BaseListener<BaseEvent> listener);
}
