/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.thread;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zyy43688
 * @version $Id: ArrayListDemo.java, v 0.1 2018年5月11日 下午9:02:11 zyy43688 Exp $
 */
@Slf4j
public class CollectionDemo {

    // 线程不安全的
    private static ArrayList<Integer>    arrayList      = new ArrayList<>();

    // 同步容器不是所有的场景下都是线程安全的
    private static Vector<Integer>       vector         = new Vector<>();

    // Collections创建同步集合
    private static List<Integer>         syncList       = Collections.synchronizedList(new ArrayList<>());

    // 线程不安全的
    private static Set<Integer>          set            = new HashSet<>();

    // 同步set
    private static Set<Integer>          syncSet        = Collections.synchronizedSet(new HashSet<>());

    // 线程不安全的
    private static Map<Integer, Integer> map            = new HashMap<>();

    // 同步容器
    private static Map<Integer, Integer> syncMap        = Collections.synchronizedMap(new HashMap<>());

    // HashTable是线程安全的，但是它不能接收key或者value的值为null
    private static Map<Integer, Integer> hashTable      = new Hashtable<>();

    private static final int             CLIENT_NUM     = 2000;
    private static final int             MAX_THREAD_NUM = 200;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        CountDownLatch countDownLatch = new CountDownLatch(CLIENT_NUM);

        Semaphore semaphore = new Semaphore(MAX_THREAD_NUM);

        for (int i = 0; i < CLIENT_NUM; i++) {
            final int count = i;
            executorService.submit(() -> {
                try {
                    semaphore.acquire();
                    add(count);
                    semaphore.release();
                } catch (Exception e) {
                    log.error("异常", e);
                }
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();

        executorService.shutdown();

        log.info("arrayList.length = {}", arrayList.size());
        log.info("syncList.length = {}", syncList.size());
        log.info("set.length = {}", set.size());
        log.info("syncSet.length = {}", syncSet.size());
        log.info("map.length = {}", map.size());
        log.info("syncMap.length = {}", syncMap.size());
        log.info("vector.length = {}", vector.size());
        log.info("hashTable.length = {}", hashTable.size());
    }

    private static void add(int i) {
        syncList.add(i);
        arrayList.add(i);
        set.add(i);
        syncSet.add(i);
        map.put(i, i);
        syncMap.put(i, i);
        vector.add(i);
        hashTable.put(i, i);
    }
}

/*
*
* 先检测
* 在执行
* 容易发生线程安全的问题
*
* 哪怕检测和执行都是线程安全的也不能保证两个操作连接在一起的时候是安全的
*
* 当对一个对象执行检测再执行的时候需要留意对象是不是多线程共享的
* 如果是多线程共享的就应该考虑线程安全的问题
* 
* */

/*
* 同步容器
*
* ArrayList
*   vector
*   stack
* hashMap
*   hashTable key和value不能为null
* Collections.synchronizedXXX
* Collections.unmodifiedXXX
*   List,set,Map
*
* synchronized
* */