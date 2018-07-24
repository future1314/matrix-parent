/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.ioc.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import zhangyuyao.ioc.annotation.bean.Girlfriend;

/**
 * Spring注解配置
 *
 * @author zyy43688
 * @version $Id: SpringAnnotationDemo.java, v 0.1 2018年7月24日 下午3:15:33 zyy43688 Exp $
 */
public class SpringAnnotationDemo {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:SpringAnnotationDemo.xml");

        Girlfriend girlfriend = (Girlfriend) context.getBean("girlfriend");

        girlfriend.angry();
    }
}