/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.jvm.classloader;

/**
 * @author zyy43688
 * @version $Id: Parent.java, v 0.1 2018年5月21日 下午1:45:15 zyy43688 Exp $
 */
public class Parent {

    public static char p = 'p';

    static {
        System.out.println(p);
    }
}