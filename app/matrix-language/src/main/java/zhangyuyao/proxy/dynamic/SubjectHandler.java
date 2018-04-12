/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 自定义调用处理器
 *
 * @author zyy43688
 * @version $Id: SubjectHandler.java, v 0.1 2018年2月26日 上午11:00:48 zyy43688 Exp $
 */
public class SubjectHandler implements InvocationHandler {

    /**
     *
     */
    private Subject target;

    public SubjectHandler(Subject target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        method.invoke(target, args);
        return new Object();
    }
}