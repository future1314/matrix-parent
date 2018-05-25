/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.thread;

import java.util.Vector;

/**
 * @author zyy43688
 * @version $Id: VectorDemo.java, v 0.1 2018年5月11日 下午9:48:44 zyy43688 Exp $
 */
public class VectorDemo {

    // 同步容器，不是线程安全的
    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {
        // 不加 while true的话不会看到一场现象
        while (true) {
            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }

            Thread t1 = new Thread(() -> {
                for (int i = 0; i < vector.size(); i++) {
                    vector.remove(i);
                }
            });
            Thread t2 = new Thread(() -> {
                for (int i = 0; i < vector.size(); i++) {
                    vector.get(i);
                }
            });

            t1.start();
            t2.start();
        }
    }
}