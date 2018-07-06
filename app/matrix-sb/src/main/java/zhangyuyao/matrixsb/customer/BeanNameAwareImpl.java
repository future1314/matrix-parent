/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.customer;

import org.springframework.beans.factory.BeanNameAware;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zyy43688
 * @version $Id: BeanNameAwareImpl.java, v 0.1 2018年6月6日 上午11:31:11 zyy43688 Exp $
 */
@Slf4j
public class BeanNameAwareImpl implements BeanNameAware {
    @Override
    public void setBeanName(String name) {
        log.info("beanName: {}", name);
    }
}