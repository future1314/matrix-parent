/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.thread;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zyy43688
 * @version $Id: ConcurrentModifiedException.java, v 0.1 2018年5月11日 下午10:23:26 zyy43688 Exp $
 */
@Slf4j
public class ConcurrentModifiedException {

    private static Vector<Integer> vector = new Vector<>();

    /**
     * java.util.ConcurrentModificationException
     * 
     * 不安全的删除会抛出异常
     */
    private static void test1() {
        for (Integer i : vector) {
            if (i.equals(3)) {
                vector.remove(i);
            }
        }
    }

    /**
     * ConcurrentModificationException
     * 
     * 不安全的删除会抛出异常
     */
    private static void test2() {
        Iterator<Integer> iterator = vector.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            if (i.equals(3)) {
                vector.remove(i);
            }
        }
    }

    /**
     * 能够安全删除
     */
    private static void test3() {
        for (int i = 0; i < vector.size(); i++) {
            if (vector.get(i).equals(3)) {
                vector.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        vector.add(1);
        vector.add(2);
        vector.add(3);

        //        test1();
        //                test2();
        test3();

        log.info(Arrays.toString(vector.toArray()));
    }

}