/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.pattern;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zyy43688
 * @version $Id: Demo.java, v 0.1 2018年6月21日 下午2:38:58 zyy43688 Exp $
 */
public class Demo {
    public static void main(String[] args) {

        // 创建线程池
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                System.out.println(SingletonDemo3.getInstance());
            });
        }

        executorService.shutdown();
    }
}