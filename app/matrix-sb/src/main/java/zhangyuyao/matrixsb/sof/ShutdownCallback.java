/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.sof;

/**
 * SOF容器关闭感知接口，在SOF容器销毁之前，会调用所有实现了该接口的实现类shutdown方法
 * 应用通过实现该接口，可以在容器销毁前，执行自定义业务逻辑
 *
 * @author zyy43688
 * @version $Id: shutdownCallback.java, v 0.1 2018年5月31日 上午11:41:40 zyy43688 Exp $
 */
public interface ShutdownCallback {

    /**
     * 在容器销毁前执行前处理操作
     * 
     * @param sofContext
     */
    void shutdown(SOFContext sofContext);
}