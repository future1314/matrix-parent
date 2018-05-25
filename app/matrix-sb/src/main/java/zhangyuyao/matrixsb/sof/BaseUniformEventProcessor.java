/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.sof;

/**
 * @author zyy43688
 * @version $Id: BaseUniformEventProcessor.java, v 0.1 2018年5月22日 下午5:37:32 zyy43688 Exp $
 */
public interface BaseUniformEventProcessor {

    /**
     * 启动统一消息处理器
     */
    void start();

    /**
     * 停止统一消息处理器
     */
    void shutdown();

    /**
     * 获取消息分组
     * 
     * @return
     */
    String getGroup();

    /**
     * 获取命名服务器
     *
     * @return
     */
    String getNameSrvAddress();
}