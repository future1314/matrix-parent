/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.jvm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zyy43688
 * @version $Id: FinalizeDemo.java, v 0.1 2018年6月20日 下午3:48:32 zyy43688 Exp $
 */
@Slf4j
public class FinalizeDemo {
    @Override
    protected void finalize() throws Throwable {
        log.info("对象被判刑！");
    }

    public static void main(String[] args) throws InterruptedException {
        new FinalizeDemo();

        System.gc();

        log.info("gc");

        Thread.sleep(1000);

        System.gc();

        Thread.sleep(1000);
    }
}