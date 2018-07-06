/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.pattern;

/**
 * 单例模式（饿汉模式）
 * 
 * 单例在类装载的时候初始化
 *
 * @author zyy43688
 * @version $Id: SingletonDemo1.java, v 0.1 2018年6月21日 下午2:21:05 zyy43688 Exp $
 */
public class SingletonDemo1 {

    /**
     * 单例初始化
     */
    private final static SingletonDemo1 instance = new SingletonDemo1();

    /**
     * 获取单例的方法
     *
     * @return
     */
    public static SingletonDemo1 getInstance() {
        return instance;
    }
}

/*
* 类加载初始化阶段会执行<clinit>方法
* 
* 虚拟机保证该方法只会被执行一次，所以这个是线程安全的
* 
* 缺点：如果有很多初始化操作执行的话可能会延长加载时间
* 
* */
