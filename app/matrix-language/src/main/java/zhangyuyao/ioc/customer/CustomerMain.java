/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.ioc.customer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;
import zhangyuyao.ioc.customer.bean.Reference;

/**
 * @author zyy43688
 * @version $Id: CustomerMain.java, v 0.1 2018年7月11日 上午10:50:26 zyy43688 Exp $
 */
@Slf4j
public class CustomerMain {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:CustomerMain.xml");

        Reference reference = (Reference) context.getBean("matrix");

        log.info(reference.toString());
    }
}