/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.thread.schedule;

import java.util.concurrent.ThreadFactory;

/**
 * 线程工厂
 *
 * @author zyy43688
 * @version $Id: MyThreadFactory.java, v 0.1 2018年5月11日 上午9:36:07 zyy43688 Exp $
 */
public class MyThreadFactory implements ThreadFactory {
    /**
     * Constructs a new {@code Thread}.  Implementations may also initialize
     * priority, name, daemon status, {@code ThreadGroup}, etc.
     *
     * @param r a runnable to be executed by new thread instance
     * @return constructed thread, or {@code null} if the request to
     * create a thread is rejected
     */
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setDaemon(false);
        return thread;
    }
}