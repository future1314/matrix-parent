package com.zhangyuyao.remote.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author 张玉尧（matrix.zhang@ximalaya.com）
 * @version $Id: MyPropertiesConfig.java, v 0.1 2018年10月30日 下午5:56:17 张玉尧（matrix.zhang@ximalaya.com） Exp $
 */
@Configuration
@PropertySource(value = {"classpath:MyProperties.properties"})
@Slf4j
public class MyPropertiesConfig implements InitializingBean {

    @Value("${firstName}")
    private String name;

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("\nafterPropertiesSet:\n{}", name);
    }
}
