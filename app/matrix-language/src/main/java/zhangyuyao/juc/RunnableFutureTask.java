/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @author zyy43688
 * @version $Id: RunnableFutureTask.java, v 0.1 2018年6月14日 上午10:07:08 zyy43688 Exp $
 */
public class RunnableFutureTask {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //
        ExecutorService executor = Executors.newCachedThreadPool();

        Object o = new Object();

        Future<Object> future = executor.submit(() -> System.out.println("just test"), o);

        System.out.println(future.get() == o);

        Future<?> newFuture = executor.submit(() -> System.out.println("submit"));

        System.out.println(newFuture.get());

        System.out.println("完美的分割线！");

        List<Callable<Integer>> callables = new ArrayList<>();

        for (int i = 0; i < 16; i++) {
            callables.add(() -> {
                Thread.sleep(1000);
                return new Random().nextInt(100);

            });
        }

        List<Future<Integer>> futures = executor.invokeAll(callables);

        futures.stream().forEach(f -> System.out.println(f.isDone()));

        executor.shutdown();
    }
}