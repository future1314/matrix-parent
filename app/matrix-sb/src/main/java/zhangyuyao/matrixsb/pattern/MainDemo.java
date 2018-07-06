/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.pattern;

/**
 * @author zyy43688
 * @version $Id: MainDemo.java, v 0.1 2018年6月12日 上午10:12:24 zyy43688 Exp $
 */
public class MainDemo {
    public static void main(String[] args) {
        System.out.println(SingletonDemo.getInstance().hashCode());
        System.out.println(SingletonDemo.getInstance().hashCode());
        System.out.println(SingletonDemo.getInstance().hashCode());
        System.out.println(SingletonDemo.getInstance().hashCode());
        System.out.println(SingletonDemo.getInstance().hashCode());
        System.out.println(SingletonDemo.getInstance().hashCode());
    }
}