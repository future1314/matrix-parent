/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.collection;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * demo
 *
 * @author zyy43688
 * @version $Id: LinkedListDemo.java, v 0.1 2018年5月28日 下午7:46:12 zyy43688 Exp $
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        Integer[] integers = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };

        List<Integer> list = new LinkedList<>();

        for (Integer i : integers) {
            if (i == 5) {
                list.add(0, i);
            } else {
                list.add(i);
            }
        }

        System.out.println(Arrays.toString(list.toArray()));
    }
}