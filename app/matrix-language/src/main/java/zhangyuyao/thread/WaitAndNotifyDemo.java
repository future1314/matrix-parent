/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.thread;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zyy43688
 * @version $Id: WaitAndNotifyDemo.java, v 0.1 2018年6月12日 上午10:24:09 zyy43688 Exp $
 */
@Slf4j
public class WaitAndNotifyDemo {

    /**
     * 消费队列
     */
    private final static List<Integer> container = new LinkedList<>();

    private static volatile boolean    flag      = true;

    public static void main(String[] args) throws InterruptedException {

        Object object = new WaitAndNotifyDemo();

        // 创建生产者线程
        Thread provider = new Thread(() -> {
            while (flag) {
                synchronized (object) {
                    int num = new Random().nextInt(100);
                    container.add(0, num);
                    log.info("生产者：{}", num);
                    object.notifyAll();
                }
            }
        });

        // 创建消费者线程
        Thread consumer = new Thread(() -> {

            while (flag) {
                synchronized (object) {
                    if (container.size() <= 0) {
                        log.info("消费者进去等待！");
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        int num = container.get(container.size() - 1);
                        log.info("消费者：{}", num);
                        container.remove(container.size() - 1);
                    }
                }
            }

            log.info("消费完剩余的数据！");

            while (container.size() > 0) {
                int num = container.get(container.size() - 1);
                log.info("消费者：{}", num);
                container.remove(container.size() - 1);
            }
        });

        // 启动生产者
        provider.start();

        // 启动消费者
        consumer.start();

        Thread.sleep(10);

        flag = false;
    }
}