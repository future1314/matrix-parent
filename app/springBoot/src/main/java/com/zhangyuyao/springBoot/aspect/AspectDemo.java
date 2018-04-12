/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.zhangyuyao.springBoot.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author zyy43688
 * @version $Id: AspectDemo.java, v 0.1 2018年3月26日 下午2:10:57 zyy43688 Exp $
 */
@Aspect
@Component
public class AspectDemo {
    @Pointcut("@annotation(SayBefore)")
    public void greetBefore() {
    }

    @Before("greetBefore()")
    public void sayBefore() {
        System.out.println("before!");
    }
}