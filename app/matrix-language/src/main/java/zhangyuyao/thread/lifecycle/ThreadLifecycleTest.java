/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.thread.lifecycle;

/**
 * 线程生命周期测试
 *
 * @author zyy43688
 * @version $Id: ThreadLifecycleTest.java, v 0.1 2018年3月27日 上午8:55:47 zyy43688 Exp $
 */
public class ThreadLifecycleTest {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 1; i <= 5; i++) {
                if (i == 1) {
                    // RUNNABLE
                    System.out.println(Thread.currentThread().getState());
                } else if (i == 2) {
                    try {
                        Thread.sleep(1000);
//                        System.out.println(Thread.currentThread().getState());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // TIMED_WAITING
                }
            }
        };

        Thread thread = new Thread(runnable);

        // NEW
        System.out.println(thread.getState());

        // RUNNABLE
        thread.start();
        System.out.println(thread.getState());

        // 很难测试出对应的状态信息
    }
}