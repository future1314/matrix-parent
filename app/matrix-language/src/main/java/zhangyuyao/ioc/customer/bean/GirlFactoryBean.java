/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.ioc.customer.bean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.lang.Nullable;

/**
 * @author zyy43688
 * @version $Id: CaoBService.java, v 0.1 2018年7月12日 下午1:52:41 zyy43688 Exp $
 */
public class GirlFactoryBean implements FactoryBean<Girl> {

    @Nullable
    @Override
    public Girl getObject() throws Exception {//
        return new Girl("1", "2", "3", "4");
    }

    @Nullable
    @Override
    public Class<?> getObjectType() {
        return Girl.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}