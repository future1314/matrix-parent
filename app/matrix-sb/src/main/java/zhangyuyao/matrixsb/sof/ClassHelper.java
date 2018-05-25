/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.sof;

/**
 * @author zyy43688
 * @version $Id: ClassHelper.java, v 0.1 2018年5月22日 下午1:55:44 zyy43688 Exp $
 */
public class ClassHelper {

    public static ClassLoader getClassLoader() {
        return getClassLoader(ClassHelper.class);
    }

    public static ClassLoader getClassLoader(Class<?> cls) {
        ClassLoader cl = null;

        try {
            cl = Thread.currentThread().getContextClassLoader();
        } catch (Throwable ex) {

        }

        if (cl == null) {
            cl = cls.getClassLoader();
        }

        return cl;
    }
}