/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.thread.juc;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zyy43688
 * @version $Id: CyclicBarrierDemo.java, v 0.1 2018年5月15日 上午11:21:57 zyy43688 Exp $
 */
@Slf4j
public class CyclicBarrierDemo {

    private static final int           THREAD_NUM    = 10;

    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> log.info("临界点"));

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < THREAD_NUM; i++) {

            final int threadNum = i + 1;

            executorService.execute(() -> {
                try {
                    Thread.sleep(1000);
                    log.info("Thread-{} is ready!", threadNum);
                    cyclicBarrier.await();
                    log.info("Thread-{} is continue!", threadNum);
                } catch (Exception e) {
                    log.error("", e);
                }
            });
        }

        executorService.shutdown();
        log.info("主线程结束！");
    }
}