/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.ioc.factory.service;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.lang.Nullable;

import lombok.extern.slf4j.Slf4j;

/**
 * 服务工厂
 *
 * @author zyy43688
 * @version $Id: ServiceFactory.java, v 0.1 2018年7月9日 下午2:21:18 zyy43688 Exp $
 */
@Slf4j
public class ServiceFactory implements FactoryBean<EarnMoneyServiceImpl> {

    private String name = "ServiceFactory";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Nullable
    @Override
    public EarnMoneyServiceImpl getObject() throws Exception {
        log.info("进入getObject方法");
        return new EarnMoneyServiceImpl();
    }

    @Nullable
    @Override
    public Class<?> getObjectType() {
        return EarnMoneyServiceImpl.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}