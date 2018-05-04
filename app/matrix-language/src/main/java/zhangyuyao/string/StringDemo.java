/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.string;

/**
 * @author zyy43688
 * @version $Id: StringDemo.java, v 0.1 2018年4月28日 下午5:35:36 zyy43688 Exp $
 */
public class StringDemo {
    public static void main(String[] args) {
        byte[] bytes = "张".getBytes();
        System.out.println(new String(bytes));
    }
}