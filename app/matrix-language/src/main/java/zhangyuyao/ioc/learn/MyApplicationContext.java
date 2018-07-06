/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.ioc.learn;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zyy43688
 * @version $Id: MyApplicationContext.java, v 0.1 2018年5月18日 下午3:54:21 zyy43688 Exp $
 */
public class MyApplicationContext extends ClassPathXmlApplicationContext {
    public static void main(String[] args) {
        System.out.println("自定义标签");
    }
}