/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.ioc.customer.bean;

import org.springframework.beans.factory.SmartInitializingSingleton;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zyy43688
 * @version $Id: Me.java, v 0.1 2018年7月12日 下午1:47:45 zyy43688 Exp $
 */
@Slf4j
public class Me implements SmartInitializingSingleton {

    @Override
    public void afterSingletonsInstantiated() {
        log.info("afterSingletonsInstantiated 方法被调用！");
    }
}