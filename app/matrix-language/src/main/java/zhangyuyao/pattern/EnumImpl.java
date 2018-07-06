/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.pattern;

/**
 * 枚举实现
 *
 * @author zyy43688
 * @version $Id: EnumImpl.java, v 0.1 2018年6月21日 下午2:55:49 zyy43688 Exp $
 */
public class EnumImpl {

    private EnumImpl() {
        // 构造函数私有化
    }

    /**
     * 获取实例
     * 
     * @return
     */
    public static EnumImpl getInstance() {
        return Singleton.INSTANCE.getSingleton();
    }

    /**
     * 创建单例
     */
    private enum Singleton {
                            INSTANCE;

        private EnumImpl singleton;

        // JVM保证这个方法绝对只被调用一次
        Singleton() {
            singleton = new EnumImpl();
        }

        public EnumImpl getSingleton() {
            return singleton;
        }
    }
}

/*
* 枚举类比于多例模式
* 
* 枚举值在构造的时候每个枚举值会调用一个构造函数，但是每个枚举有且就有一次调用其构造函数
*
* name是不是
* */