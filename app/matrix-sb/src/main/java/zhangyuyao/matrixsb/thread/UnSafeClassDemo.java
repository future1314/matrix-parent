/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.thread;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zyy43688
 * @version $Id: UnSsfeClassDemo.java, v 0.1 2018年5月11日 下午8:22:27 zyy43688 Exp $
 */
@Slf4j
public class UnSafeClassDemo {

    // 不安全的StringBuilder
    private static StringBuilder     stringBuilder     = new StringBuilder();

    // 线程安全的StringBuffer
    private static StringBuffer      stringBuffer      = new StringBuffer();

    // 线程不安全的SimpleDateFormat
    private static SimpleDateFormat  simpleDateFormat  = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

    // 线程安全的DateTimeFormat
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("YYYY-MM-dd HH:mm:ss");

    private static int               num;

    private static final int         CLIENT_NUM        = 2000;
    private static final int         MAX_THREAD_NUM    = 200;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        CountDownLatch countDownLatch = new CountDownLatch(CLIENT_NUM);

        Semaphore semaphore = new Semaphore(MAX_THREAD_NUM);

        for (int i = 0; i < CLIENT_NUM; i++) {
            executorService.submit(() -> {
                try {
                    semaphore.acquire();
                    process();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("异常", e);
                }
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();

        executorService.shutdown();

        log.info("计数操作结果：{}", num);
        log.info("StringBuilder结果：{}", stringBuilder.length());
        log.info("StringBuffer结果：{}", stringBuffer.length());
        log.info("Joda-Time结果：{}", dateTimeFormatter.parseDateTime("1994-12-17 18:00:00"));
    }

    private static void process() throws ParseException {
        num++;
        stringBuilder.append("1");
        stringBuffer.append("1");
        //        simpleDateFormat.parse("1994-12-17 18:00:00");
        dateTimeFormatter.parseDateTime("1994-12-17 18:00:00");
    }
}