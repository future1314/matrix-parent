/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.juc;

/**
 * @author zyy43688
 * @version $Id: CallableDemo.java, v 0.1 2018年6月13日 上午11:37:32 zyy43688 Exp $
 */
public interface CallableDemo<T> {

    /**
     * 执行
     * 
     * @return
     * @throws Exception
     */
    T call() throws Exception;
}