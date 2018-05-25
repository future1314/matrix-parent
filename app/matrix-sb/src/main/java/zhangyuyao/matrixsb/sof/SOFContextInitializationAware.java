/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.sof;

/**
 * 容器初始化感知接口，应用实现该接口，可以在容器启动的时候执行自定义的业务逻辑
 * 
 * @author zyy43688
 * @version $Id: SOFContextInitializationAware.java, v 0.1 2018年5月22日 下午4:16:28 zyy43688 Exp $
 */
public interface SOFContextInitializationAware {
    void init();
}