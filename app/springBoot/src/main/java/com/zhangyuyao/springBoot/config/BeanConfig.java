/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.zhangyuyao.springBoot.config;

import com.zhangyuyao.springBoot.service.ServiceDemo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zyy43688
 * @version $Id: BeanConfig.java, v 0.1 2018年3月26日 下午2:09:15 zyy43688 Exp $
 */
@Configuration
public class BeanConfig {
    @Bean
    public ServiceDemo createServiceDemo() {
        return new ServiceDemo();
    }
}