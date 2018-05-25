/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zyy43688
 * @version $Id: ThreadStateDemo.java, v 0.1 2018年5月23日 下午2:26:04 zyy43688 Exp $
 */
@Slf4j
public class ThreadStateDemo {

    public static void main(String[] args) {

        // 创建线程
        Thread t = new Thread(() -> {
            System.out.println("线程开始执行");
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException("就是测试的线程！");
            }
            System.out.println("线程已经醒了！");
        });
        t.setName("测试线程！");

        t.start();

        // 主线程等待一秒钟然子线程进入sleep方法
        try {
            Thread.sleep(1000);
            System.out.println("主线程结束！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(t.getState());

        t.interrupt();

        t.setUncaughtExceptionHandler((t1, e) -> {
            log.info("处理器里面捕获到了异常");
            System.out.println(t1.getName());
        });
    }
}