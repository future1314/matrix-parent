/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.thread.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import lombok.extern.java.Log;

/**
 * @author zyy43688
 * @version $Id: ScheduleDemo.java, v 0.1 2018年5月11日 上午9:39:27 zyy43688 Exp $
 */
@Log
public class ScheduleDemo {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");

    public static void main(String[] args) throws InterruptedException {

        System.out.println(simpleDateFormat.format(new Date()));

        log.info("创建调度程序！");

        // 创建调度
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor(new MyThreadFactory());

        scheduledExecutorService.scheduleAtFixedRate(() -> System.out.println(simpleDateFormat.format(new Date())), 0, 3, TimeUnit.SECONDS);

        log.info("调度程序启动！");
    }
}