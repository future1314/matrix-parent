/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.pattern;

/**
 * 
 * 第一次使用的时候创建
 * 
 * 高并发效率低，需要获取锁
 * 
 * @author zyy43688
 * @version $Id: SingletonDemo5.java, v 0.1 2018年6月21日 下午4:45:32 zyy43688 Exp $
 */
public class SingletonDemo5 {

    private SingletonDemo5() {
        // 构造函数私有化
    }

    private static SingletonDemo5 instance;

    private synchronized static SingletonDemo5 getInstance() {
        if (instance == null) {
            instance = new SingletonDemo5();
        }

        return instance;
    }
}