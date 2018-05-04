/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.collection;

import java.util.ArrayList;
import java.util.Vector;

/**
 * 
 * ArrayList 线程不安全的 Vector 是线程安全的
 * 
 * @author zyy43688
 * @version $Id: ArrayListAndVectorDemo.java, v 0.1 2018年4月27日 上午9:41:11 zyy43688 Exp $
 */
public class ArrayListAndVectorDemo {

    /**
     * 添加次数
     */
    private final static int FREQUENCY = 10000;

    public static void main(String[] args) {

        ArrayList<Integer> integerArrayList = new ArrayList<>();

        Vector<Integer> integerVector = new Vector<>();

        new Thread(() -> {
            for (int i = 1; i <= FREQUENCY; i++) {
                integerArrayList.add(1);
                Thread.yield();
                integerVector.add(1);
            }

            System.out.println("线程1执行结束！");
        }).start();

        new Thread(() -> {
            for (int i = 1; i < FREQUENCY; i++) {
                integerArrayList.add(1);
                Thread.yield();
                integerVector.add(1);
            }

            System.out.println("线程2执行结束！");
        }).start();

        // 等待主线程结束
        // 这个方法应该是怎么处理的呢？
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println("主线程结束！");

        System.out.println(integerArrayList.size());
        System.out.println(integerVector.size());
    }
}