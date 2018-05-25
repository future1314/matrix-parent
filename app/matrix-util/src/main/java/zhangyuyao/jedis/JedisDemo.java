/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.jedis;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import redis.clients.jedis.Jedis;

/**
 * @author zyy43688
 * @version $Id: JedisDemo.java, v 0.1 2018年5月11日 下午5:21:17 zyy43688 Exp $
 */
public class JedisDemo {

    // 最大线程数
    private final static int MAX_CLIENT = 100;

    // 允许最大并发数
    private final static int MAX_THREAD = 2;

    // Jedis连接
    private static Jedis     client;

    public static void main(String[] args) throws InterruptedException {

        client = new Jedis("116.85.24.185", 6379);

        // 线程池
        ExecutorService executorService = Executors.newCachedThreadPool();

        // CountDownLatch
        CountDownLatch countDownLatch = new CountDownLatch(MAX_CLIENT);

        // 信号量
        Semaphore semaphore = new Semaphore(MAX_THREAD);

        for (int i = 0; i < MAX_CLIENT; i++) {

            final String e = String.valueOf(i + 1);

            // 提交线程
            executorService.execute(() -> {
                try {
                    semaphore.acquire();

                    lPush("elements", e);

                } catch (Exception exception) {
                    exception.printStackTrace();
                } finally {
                    semaphore.release();
                    countDownLatch.countDown();
                }
            });
        }

        executorService.shutdown();
        // 主线程等待
        countDownLatch.await();

        System.out.println("主线程结束！");

        System.out.println(client.llen("elements"));
    }

    private synchronized static void lPush(String elements, String e) {
        client.lpush("elements", e);
    }
}