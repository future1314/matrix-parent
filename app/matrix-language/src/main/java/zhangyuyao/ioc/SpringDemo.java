/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zyy43688
 * @version $Id: SpringDemo.java, v 0.1 2018年5月18日 下午3:21:11 zyy43688 Exp $
 */
@Slf4j
public class SpringDemo {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:springDemo.xml");

        Msg msg = (Msg) applicationContext.getBean("msg");

        ((ClassPathXmlApplicationContext) applicationContext).close();
    }
}