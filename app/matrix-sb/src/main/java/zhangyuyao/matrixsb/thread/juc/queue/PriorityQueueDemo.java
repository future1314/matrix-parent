/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.thread.juc.queue;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author zyy43688
 * @version $Id: PriorityQueueDemo.java, v 0.1 2018年7月2日 下午4:32:22 zyy43688 Exp $
 */
public class PriorityQueueDemo {

    private final static Queue<String> queue = new PriorityQueue<>();

    public static void main(String[] args) {
        // 新增
        queue.add("d");
        queue.add("b");

        System.out.println(queue.offer("c"));

        while (queue.peek() != null) {
            System.out.println(queue.remove());
        }
    }
}