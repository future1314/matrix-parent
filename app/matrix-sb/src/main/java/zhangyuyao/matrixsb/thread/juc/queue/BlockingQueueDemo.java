/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.thread.juc.queue;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 阻塞队列
 *
 * @author zyy43688
 * @version $Id: BlockingQueueDemo.java, v 0.1 2018年7月2日 下午2:03:21 zyy43688 Exp $
 */
public class BlockingQueueDemo {

    private final static int                   LEN   = 10;

    private final static BlockingQueue<String> queue = new ArrayBlockingQueue<>(LEN);

    private static volatile boolean            flag  = true;

    public static void main(String[] args) throws InterruptedException, IOException {
        BlockingQueueDemo.providers();
        BlockingQueueDemo.consumers();
        System.in.read();
        flag = false;
    }

    private static void providers() {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 3; i++) {
            executorService.execute(() -> {
                while (flag) {
                    try {
                        queue.put(String.valueOf(new Date().getTime()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        executorService.shutdown();
    }

    private static void consumers() {

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 3; i++) {
            executorService.execute(() -> {
                while (flag) {
                    String e = null;
                    try {
                        e = queue.take();
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    System.out.println(e);
                }
            });
        }

        executorService.shutdown();
    }
}

// 入队列
// 出队列

// 新增、删除
// 阻塞

// 生产者消费者模式

// 共用一个队列

//