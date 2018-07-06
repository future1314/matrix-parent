/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.pattern;

/**
 * 
 * 枚举实现
 * 
 * @author zyy43688
 * @version $Id: SingletonDemo4.java, v 0.1 2018年6月21日 下午2:46:49 zyy43688 Exp $
 */
public class SingletonDemo4 {

    private SingletonDemo4() {

    }

    /**
     * 外部直接返回值
     * 
     * @return
     */
    public static SingletonDemo4 getInstance() {
        return Handler.singletonDemo4.instance;
    }

    // 虚拟机保证单例的创建
    private enum Handler {

                          singletonDemo4;

        private SingletonDemo4 instance;

        Handler() {
            instance = new SingletonDemo4();
        }
    }
}