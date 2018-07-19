/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.ioc.lifecycle.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zyy43688
 * @version $Id: MyDisposableBean.java, v 0.1 2018年7月19日 下午4:21:06 zyy43688 Exp $
 */
@Slf4j
public class MyDisposableBean implements DestructionAwareBeanPostProcessor {

    @Override
    public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
        log.info(beanName);
    }
}