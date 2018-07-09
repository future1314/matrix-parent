/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.ioc.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;
import zhangyuyao.ioc.lifecycle.bean.Person;
import zhangyuyao.ioc.lifecycle.bean.Staff;

/**
 * @author zyy43688
 * @version $Id: SpringMain.java, v 0.1 2018年7月6日 下午3:42:08 zyy43688 Exp $
 */
@Slf4j
public class SpringMain {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:SpringMain.xml");

        Staff staff = (Staff) context.getBean("zhangyuyao.ioc.lifecycle.bean.Staff#0");

        Person person = (Person) context.getBean("person");
    }
}