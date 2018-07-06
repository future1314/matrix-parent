/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.pattern;

/**
 * 单例模式
 *
 * 第一次使用的时候创建
 *
 * @author zyy43688
 * @version $Id: SingletonDemo3.java, v 0.1 2018年6月21日 下午2:31:24 zyy43688 Exp $
 */
public class SingletonDemo3 {

    /**
     * 实例
     */
    private static SingletonDemo3 instance;

    private SingletonDemo3() {
        try {
            System.out.println("进去线程等待");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 初始化方法
     * 
     * @return
     */
    public static SingletonDemo3 getInstance() {
        if (instance == null) {// 双重检测机制
            synchronized (SingletonDemo3.class) {// 同步锁
                if (instance == null) {
                    instance = new SingletonDemo3();
                }
            }
        }

        return instance;
    }
}

/*
* 1.创建内存
* 2.初始化
* 3.赋值内存地址
* 
* JVM和CPU优化，发生了指令重排
* 
* 所以可能会发生对象逃逸的现象
* */