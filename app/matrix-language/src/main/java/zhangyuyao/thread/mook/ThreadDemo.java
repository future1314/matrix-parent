/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.thread.mook;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zyy43688
 * @version $Id: ThreadDemo.java, v 0.1 2018年4月12日 上午10:43:54 zyy43688 Exp $
 */
public class ThreadDemo {
    /**
     * 最大线程数
     */
    private final static int     MAX_NUM       = 500;

    /**
     * 允许运行的最多的线程数
     */
    private final static int     MAX_ACCEPT    = 200;

    /**
     *
     */
    private static volatile int  num           = 0;

    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        ThreadDemo threadDemo = new ThreadDemo();
        ExecutorService executor = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(MAX_NUM);

        Semaphore semaphore = new Semaphore(MAX_ACCEPT);

        for (int i = 1; i <= MAX_NUM; i++) {
            Runnable runnable = () -> {
                try {
                    semaphore.acquire();
                    threadDemo.increase();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            };
            executor.execute(runnable);
        }
        executor.shutdown();
        // 等待所有的线程结束
        countDownLatch.await();
        executor.shutdown();
        System.out.println(Thread.activeCount());

        System.out.println(num);
        System.out.println(atomicInteger.get());
    }

    /**
     *
     */
    public void increase() {
        num++;
        atomicInteger.incrementAndGet();
    }
}