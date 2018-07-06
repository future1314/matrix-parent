/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author zyy43688
 * @version $Id: Future.java, v 0.1 2018年6月13日 上午11:46:30 zyy43688 Exp $
 */
public interface FutureDemo<T> {
    /**
     * 取消
     * 
     * @param mayInterruptIfRunning
     * @return
     */
    boolean cancel(boolean mayInterruptIfRunning);

    /**
     * 是否已经取消
     * 
     * @return
     */
    boolean isCanceled();

    /**
     * 是否已完成
     * 
     * @return
     */
    boolean isDone();

    /**
     * 获取执行结果
     * 
     * @return
     * @throws InterruptedException
     * @throws ExecutionException
     */
    T get() throws InterruptedException, ExecutionException;

    /**
     * 等到超时执行结果
     * 
     * @param timeout
     * @param unit
     * @return
     * @throws InterruptedException
     * @throws ExecutionException
     * @throws TimeoutException
     */
    T get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException;
}