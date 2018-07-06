/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.dubbo;

import lombok.extern.java.Log;

/**
 * @author zyy43688
 * @version $Id: Consumer.java, v 0.1 2018年5月25日 下午4:36:59 zyy43688 Exp $
 */
@Log
public class Consumer {

    //    private static DemoService demoService;
    //
    //    static {
    //        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "dubbo.xml" });
    //        context.start();
    //        // obtain proxy object for remote invocation
    //        demoService = (DemoService) context.getBean("demoService");
    //    }
    //
    //    public static void main(String[] args) throws Exception {
    //
    //        CountDownLatch countDownLatch = new CountDownLatch(100);
    //
    //        ExecutorService executorService = Executors.newCachedThreadPool();
    //
    //        for (int i = 0; i < 100; i++) {
    //
    //            int t = i;
    //
    //            executorService.submit(() -> {
    //                try {
    //                    demoService.sayHello(String.valueOf(t));
    //                }finally {
    //                    countDownLatch.countDown();
    //                }
    //            });
    //        }
    //
    //        log.info("等待子线程结束！");
    //        executorService.shutdown();
    //        countDownLatch.await();
    //
    //        log.info("子线程执行结束！");
    //    }
}