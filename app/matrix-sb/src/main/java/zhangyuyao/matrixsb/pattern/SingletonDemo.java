/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.pattern;

/**
 * @author zyy43688
 * @version $Id: SingletonDemo.java, v 0.1 2018年6月12日 上午10:09:57 zyy43688 Exp $
 */
public class SingletonDemo {

    public static SingletonDemo getInstance() {
        return Handler.INSTANCE;
    }

    private static final class Handler {
        private static SingletonDemo INSTANCE = new SingletonDemo();
    }
}