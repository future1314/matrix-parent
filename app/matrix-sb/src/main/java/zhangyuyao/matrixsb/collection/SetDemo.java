/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.collection;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zyy43688
 * @version $Id: SetDemo.java, v 0.1 2018年5月15日 下午1:39:12 zyy43688 Exp $
 */
public class SetDemo {
    public static void main(String[] args) {
        Set<String> sets = new HashSet<>();
        sets.add("1");
        sets.add("2");
        sets.add("3");
        sets.add("4");
        sets.add("5");
        sets.add("6");

        for (String s : sets) {
            System.out.println(s);
        }

        /*
        * 
        * 紊乱所以过度
        * 
        * */
    }
}