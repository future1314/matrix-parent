/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zyy43688
 * @version $Id: ThreadLocalDemo.java, v 0.1 2018年6月12日 上午11:14:24 zyy43688 Exp $
 */
@Slf4j
public class ThreadLocalDemo {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {

        threadLocal.set("matrix");
        log.info("hashCode: {}, value: {}", threadLocal.hashCode(), threadLocal.get());

        // thread1
        Thread thread1 = new Thread(() -> {
            threadLocal.set("is");
            log.info("thread1 hashCode: {}, value: {}", threadLocal.hashCode(), threadLocal.get());
        });

        // thread2
        Thread thread2 = new Thread(() -> {
            threadLocal.set("a good man!");
            log.info("thread2 hashCode: {}, value: {}", threadLocal.hashCode(), threadLocal.get());
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        log.info("finish");
    }
}