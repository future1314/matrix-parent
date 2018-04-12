/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.zhangyuyao.springBoot.service;

import com.zhangyuyao.springBoot.aspect.SayBefore;

/**
 * @author zyy43688
 * @version $Id: ServiceDemo.java, v 0.1 2018年3月26日 下午2:08:45 zyy43688 Exp $
 */
public class ServiceDemo {

    @SayBefore
    public void say() {
        System.out.println("Hello!");
    }
}