/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.ioc.lifecycle.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zyy43688
 * @version $Id: Person.java, v 0.1 2018年7月6日 下午4:00:38 zyy43688 Exp $
 */
@Slf4j
public class Person implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, ApplicationContextAware {

    private String name;

    @Override
    public void setBeanName(String name) {
        this.name = name;
        log.info("setBeanName {}", name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        log.info(classLoader.toString());
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.info("setBeanFactory接口被调用");
        log.info("是否是单例：{}", beanFactory.isSingleton(name));
        log.info("是否是ApplicationContext的实例：{}", beanFactory instanceof ApplicationContext);
        log.info("是哪个类的实例：{}", beanFactory.getClass());
        log.info("setBeanFactory接口调用结束");
    }

    public void init() {
        log.info("初始化方法被调用！");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("setApplicationContext接口被调用");
    }
}