/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.ioc.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;
import zhangyuyao.ioc.factory.service.EarnMoneyServiceImpl;
import zhangyuyao.ioc.factory.service.ServiceFactory;

/**
 * 工厂bean实例
 *
 * @author zyy43688
 * @version $Id: FactoryBeanDemo.java, v 0.1 2018年7月9日 下午2:20:00 zyy43688 Exp $
 */
@Slf4j
public class FactoryBeanDemo {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:FactoryBeanDemo.xml");

        // 获取EarnMoneyServiceImpl实例
        EarnMoneyServiceImpl earnMoneyService = (EarnMoneyServiceImpl) context.getBean("earnMoneyService");

        // 获取ServiceFactory实例
        ServiceFactory serviceFactory = (ServiceFactory) context.getBean("&earnMoneyService");

        log.info("earnMoneyService's name is {}", earnMoneyService.getName());
        log.info("serviceFactory's name is {}", serviceFactory.getName());
    }
}

/*
* 在使用FactoryBean自定义Bean的时候可以通过ID进行Bean的注入
* 
* 如果想要直接获取FactoryBean的实例那就使用&+ID作为name获取Bean的实例
* 
* */