/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.zhangyuyao.remote.biz;

/**
 * @author zyy43688
 * @version $Id: RequestThreadHandler.java, v 0.1 2018年5月11日 上午10:33:02 zyy43688 Exp $
 */
public class RequestThreadHandler {

    private final static ThreadLocal<Long> requestThreadHandler = new ThreadLocal<>();

    public static void set(Long id) {
        requestThreadHandler.set(id);
    }

    public static Long get() {
        return requestThreadHandler.get();
    }

    public static void remove() {
        requestThreadHandler.remove();
    }

    public static int getHashCode() {
        return requestThreadHandler.hashCode();
    }
}