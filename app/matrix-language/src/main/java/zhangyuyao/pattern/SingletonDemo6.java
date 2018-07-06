/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.pattern;

/**
 * @author zyy43688
 * @version $Id: SingletonDemo6.java, v 0.1 2018年6月21日 下午5:03:38 zyy43688 Exp $
 */
public class SingletonDemo6 {

    private SingletonDemo6() {
    }

    // 禁止指令重排+双重检测机制
    private volatile static SingletonDemo6 instance;

    public static SingletonDemo6 getInstance() {
        if (instance == null) {
            synchronized (SingletonDemo6.class) {
                if (instance == null) {
                    instance = new SingletonDemo6();
                }
            }
        }

        return instance;
    }
}