/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.ioc.lifecycle.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.StringValueResolver;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zyy43688
 * @version $Id: Wife.java, v 0.1 2018年7月19日 上午10:59:59 zyy43688 Exp $
 */
@Slf4j
public class Wife implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, EnvironmentAware, EmbeddedValueResolverAware, ResourceLoaderAware,
                  ApplicationEventPublisherAware, MessageSourceAware, ApplicationContextAware, InitializingBean, DisposableBean {

    private void init() {
        log.info("init");
    }

    public void destroy() {
        log.info("destroy");
    }

    private void MySelfDestroy(){
        log.info("MySelfDestroy");
    }
    @Override
    public void setBeanName(String name) {
        log.info("setBeanName");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        log.info("setBeanClassLoader");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.info("setBeanFactory");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("setApplicationContext");
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        log.info("setApplicationEventPublisher");
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        log.info("setEmbeddedValueResolver");
    }

    @Override
    public void setEnvironment(Environment environment) {
        log.info("setEnvironment");
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        log.info("setMessageSource");
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        log.info("setResourceLoader");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("afterPropertiesSet");
    }
}