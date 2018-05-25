/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.sof;

/**
 * @author zyy43688
 * @version $Id: StartupCallback.java, v 0.1 2018年5月22日 下午5:24:32 zyy43688 Exp $
 */
public interface StartupCallback extends Order {
    /** 默认顺序 */
    static final int DEFAULT_ORDER = 99;

    /**
     * 执行容器启动后的后处理操作
     *
     * @param context SOF上下文
     */
    void startup(SOFContext context);
}