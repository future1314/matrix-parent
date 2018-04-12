/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.thread.jvm;

/**
 * 内存可见性demo
 *
 * @author zyy43688
 * @version $Id: MemoryVisibilityDemo.java, v 0.1 2018年4月12日 下午6:58:42 zyy43688 Exp $
 */
public class MemoryVisibilityDemo {

    /**
     * 线程数量
     */
    private static int THREAD_NUM = 20;

    /**
     * 计数器
     */
    private static int count = 0;

    /**
     * 自增1
     */
    public static void increase(){
        count++;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Thread[] threads = new Thread[THREAD_NUM];

        for (int i = 0; i < threads.length; i++){
            threads[i] = new Thread(() -> {
                for(int j = 1; j <= 1000; j++){
                    increase();
                }
            });

            threads[i].start();
        }

        while (Thread.activeCount() > 1){
            Thread.yield();
        }

        System.out.println(count);
    }
}