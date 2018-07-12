/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.ioc.customer.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zyy43688
 * @version $Id: MyBeanPostProcessor.java, v 0.1 2018年7月12日 下午3:47:42 zyy43688 Exp $
 */
@Slf4j
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Nullable
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("postProcessBeforeInitialization benName is {}", beanName);
        return bean;
    }

    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("postProcessAfterInitialization benName is {}", beanName);
        return bean;
    }
}