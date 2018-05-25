/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zyy43688
 * @version $Id: ScheduleDemo.java, v 0.1 2018年5月17日 上午10:55:59 zyy43688 Exp $
 */
@Slf4j
public class ScheduleDemo {

    private static ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

    static {
        scheduledExecutorService.scheduleWithFixedDelay(() -> log.info(new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date())), 0, 3, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        log.info("start..");
    }
}