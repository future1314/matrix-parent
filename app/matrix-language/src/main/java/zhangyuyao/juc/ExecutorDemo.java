/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.juc;

/**
 * @author zyy43688
 * @version $Id: ExecutorDemo.java, v 0.1 2018年6月13日 上午9:58:09 zyy43688 Exp $
 */
public interface ExecutorDemo {
    void execute(Runnable command);
}

/**
 * 其实就是定义的任务而已
 * 
 * 有返回值和没有返回值的差别
 * 
 * */