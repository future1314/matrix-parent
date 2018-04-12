/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.thread;

/**
 * @author zyy43688
 * @version $Id: ThreadSleepDemo.java, v 0.1 2018年3月27日 上午9:59:34 zyy43688 Exp $
 */
public class ThreadSleepDemo {

    public int total = 1;

    public static void main(String[] args) {

        ThreadSleepDemo threadSleepDemo = new ThreadSleepDemo();

        // 创建两个线程一个对象
        new Thread(() -> {
            threadSleepDemo.reduction();
        }, "线程1").start();

        new Thread(() -> {
            threadSleepDemo.reduction();
        }, "线程2").start();
    }

    /**
     * 自减1
     */
    public synchronized void reduction() {
        System.out.println("进入线程：" + Thread.currentThread().getName());
        if (total > 0) {
            /*wait会失去对锁的控制*/
            try {
                wait(1000);// 等待一秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            /*sleep不会失去对锁的控制*/
//            try {
//                Thread.sleep(1000);// 等待一秒钟
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            total = total - 1;
            System.out.println("执行行程：" + Thread.currentThread().getName() + "，结果：" + total);
        }
    }
}