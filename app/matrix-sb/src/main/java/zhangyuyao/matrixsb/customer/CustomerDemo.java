/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.customer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zyy43688
 * @version $Id: CustomerDemo.java, v 0.1 2018年5月18日 下午4:57:38 zyy43688 Exp $
 */
@Slf4j
public class CustomerDemo {
    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:matrix.xml");

        Matrix matrix = (Matrix) context.getBean("zhangyuyao");

        log.info("description: {}", matrix.getDescription());
    }
}