/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.time;

import org.springframework.util.StopWatch;

/**
 * @author zyy43688
 * @version $Id: TimeDemo.java, v 0.1 2018年7月2日 上午11:31:53 zyy43688 Exp $
 */
public class TimeDemo {
    public static void main(String[] args) throws InterruptedException {
        // 定义一个计数器

        StopWatch stopWatch = new StopWatch("统一一组任务耗时");

        stopWatch.start("任务一");

        Thread.sleep(1000);

        stopWatch.stop();

        stopWatch.start("任务二");

        Thread.sleep(2000);

        stopWatch.stop();


        String result = stopWatch.prettyPrint();

        System.err.println(result);

    }
}