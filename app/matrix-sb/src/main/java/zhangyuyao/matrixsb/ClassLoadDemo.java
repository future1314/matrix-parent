/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb;

/**
 * @author zyy43688
 * @version $Id: ClassLoadDemo.java, v 0.1 2018年5月17日 下午4:54:34 zyy43688 Exp $
 */
public class ClassLoadDemo {
    public static void main(String[] args) {
        System.out.println(ClassLoadDemo.class.getClassLoader());
        System.out.println(String.class.getClassLoader());
    }
}