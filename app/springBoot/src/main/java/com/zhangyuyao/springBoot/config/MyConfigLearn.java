package com.zhangyuyao.springBoot.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * @author 张玉尧（matrix.zhang@ximalaya.com）
 * @version $Id: MyConfigLearn.java, v 0.1 2018年10月30日 上午11:51:02 张玉尧（matrix.zhang@ximalaya.com） Exp $
 */
@Configuration
@PropertySource(value = "classpath:MyProperties.properties")
@Slf4j
public class MyConfigLearn implements InitializingBean {

    @Autowired
    private Environment environment;

    @Value("${lastName}")
    private String name;

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("\nafterPropertiesSet:\n{}", environment.getProperty("name"));
    }
}
