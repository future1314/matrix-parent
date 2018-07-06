/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.customer;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zyy43688
 * @version $Id: BeanFactoryAwareImpl.java, v 0.1 2018年6月6日 下午1:41:59 zyy43688 Exp $
 */
@Slf4j
public class BeanFactoryAwareImpl implements BeanFactoryAware {
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.info("beanFactory : {}", beanFactory);
    }
}