/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.sof;

/**
 * @author zyy43688
 * @version $Id: SOFContext.java, v 0.1 2018年5月21日 下午5:42:17 zyy43688 Exp $
 */
public interface SOFContext extends ListenerRegister {

    /**
     * 获取容器ID
     *
     * @return
     */
    String getId();

    /**
     * 获取应用名称
     *
     * @return
     */
    String getAppName();

    /**
     * 获取容器运行时名称
     *
     * @return
     */
    String getContextName();

    /**
     * 获取容器启动时间
     *
     * @return
     */
    long getStartupDate();

    /**
     * 启动容器
     *
     * @return
     */
    boolean init();

    /**
     * 关闭容器
     */
    void shutdown();

    /**
     * 容器是否运行
     */
    boolean isRunning();

    /**
     * 事件投递
     */
    void fireEvent(BaseEvent event, boolean sync);

    /**
     * 获取系统注册的事件广播器
     */
    EventMulticaster getEventMulticaster();

    /**
     * 设置事件广播器
     */
    void setEventMulticaster(EventMulticaster eventMulticaster);

    /**
     * 获取应用配置
     */
    AppConfiguration getAppConfiguration();
}
