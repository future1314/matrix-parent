/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zyy43688
 * @version $Id: ThreadWaitDemo.java, v 0.1 2018年6月12日 上午9:51:15 zyy43688 Exp $
 */
public class ThreadWaitDemo {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("start...");

        Lock lock = new ReentrantLock();

        lock.lock();
        System.out.println("lock");
        new ThreadWaitDemo().test();
        lock.unlock();
        System.out.println("unlock");
        System.out.println("end...");
    }

    public synchronized void test() throws InterruptedException {
        this.wait();
    }
}