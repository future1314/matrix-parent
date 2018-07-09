/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.ioc.lifecycle.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.Nullable;

import lombok.extern.slf4j.Slf4j;

/**
 * 职工
 *
 * @author zyy43688
 * @version $Id: Staff.java, v 0.1 2018年7月6日 下午3:42:33 zyy43688 Exp $
 */
@Slf4j
public class Staff implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, ApplicationContextAware, BeanPostProcessor, InitializingBean {

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

    private void init() {
        log.info("初始化方法被调用");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("setApplicationContext接口被调用");
    }

    @Nullable
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("postProcessBeforeInitialization 方法被调用，beanName is {}", beanName);
        log.info("bean 是否是Staff的实例：{}", bean instanceof Staff);
        log.info("bean 是否是BeanDefinition的实例：{}", bean instanceof BeanDefinition);
        log.info("postProcessBeforeInitialization 方法执行结束");
        return bean;
    }

    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("postProcessAfterInitialization 方法被调用，beanName is {}", beanName);
        log.info("bean 是否是Staff的实例：{}", bean instanceof Staff);
        log.info("bean 是否是BeanDefinition的实例：{}", bean instanceof BeanDefinition);
        log.info("postProcessAfterInitialization 方法执行结束");
        return bean;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("afterPropertiesSet方法被执行");
    }
}