/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.pattern;

/**
 * 单例模式（懒汉模式）
 *
 * 单例在第一次使用的时候初始化
 *
 * @author zyy43688
 * @version $Id: SingletonDemo2.java, v 0.1 2018年6月21日 下午2:27:24 zyy43688 Exp $
 */
public class SingletonDemo2 {

    private SingletonDemo2() {
    }

    /**
     * 单例
     */
    private static SingletonDemo2 instance;

    /**
     * 典型的先判断再执行，该操作是存在线程安全的隐患的
     * 
     * @return
     */
    private static SingletonDemo2 getInstance() {

        if (instance == null) {
            instance = new SingletonDemo2();
        }

        return instance;
    }
}