/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.*;
import org.springframework.core.io.ResourceLoader;
import org.springframework.lang.Nullable;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zyy43688
 * @version $Id: Msg.java, v 0.1 2018年5月18日 下午3:22:37 zyy43688 Exp $
 */
@Slf4j
public class Msg extends RootBeanDefinition implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, ResourceLoaderAware, ApplicationEventPublisherAware,
                 MessageSourceAware, ApplicationContextAware, BeanPostProcessor, InitializingBean {

    void init() {
        log.info("init-method方法被调用");
    }

    void destroy() {
        log.info("destroy-method方法被调用");
    }

    @Override
    public void setBeanName(String name) {
        log.info("setBeanName: {}", name);
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        log.info("setBeanClassLoader: {}", classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.info("setBeanFactory: {}", beanFactory.getClass());
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        log.info("setResourceLoader: {}", resourceLoader);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        log.info("setApplicationEventPublisher: {}", applicationEventPublisher);
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        log.info("setMessageSource: {}", messageSource);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("setApplicationContext: {}", applicationContext);
    }

    @Nullable
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("postProcessBeforeInitialization: bean {}, beamName {}", bean.getClass(), beanName);
        return bean;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("afterPropertiesSet");
    }

    @Nullable
    @Override
    public String getInitMethodName() {
        log.info("getInitMethodName: {}", super.getInitMethodName());
        return super.getInitMethodName();
    }

    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("postProcessAfterInitialization: bean {}, beanName {}", bean.getClass(), beanName);
        return bean;
    }
}