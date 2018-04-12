/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.thread.mook;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author zyy43688
 * @version $Id: ThreadDemo.java, v 0.1 2018年4月12日 上午10:43:54 zyy43688 Exp $
 */
public class ThreadDemo {
    /**
     * 最大线程数
     */
    private final static int MAX_NUM = 500;

    /**
     * 允许运行的最多的线程数
     */
    private final int MAX_ACCEPT = 200;

    /**
     *
     */
    private static volatile int num = 0;

    /**
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        ThreadDemo threadDemo = new ThreadDemo();
        Executor executor = Executors.newCachedThreadPool();

        Semaphore semaphore = new Semaphore(200);

        for(int i = 1; i <= MAX_NUM; i++){
            Runnable runnable = () -> threadDemo.increase();
            executor.execute(runnable);
        }


        System.out.println(num);
    }

    /**
     *
     */
    public void increase(){
        num ++;
    }
}