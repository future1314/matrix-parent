/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.zhangyuyao.springBoot.transaction.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

/**
 * @author zyy43688
 * @version $Id: TransactionBeanConfig.java, v 0.1 2018年3月30日 下午2:32:11 zyy43688 Exp $
 */
@Configuration
public class TransactionBeanConfig {

    /**
     * @param myDataSource
     * @return
     */
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource myDataSource) {
        return new JdbcTemplate(myDataSource);
    }

    /**
     * @return
     */
    @Bean(name = "myDataSource")
    public DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();

        driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/myBatis?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=false");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("225821zyy");

        return driverManagerDataSource;
    }

    /**
     * @param myDataSource
     * @return
     */
    @Bean(name = "dataSourceTransactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource myDataSource) {
        return new DataSourceTransactionManager(myDataSource);
    }

    /**
     * @param dataSourceTransactionManager
     * @return
     */
    @Bean(name = "transactionTemplate")
    public TransactionTemplate transactionTemplate(PlatformTransactionManager dataSourceTransactionManager) {
        return new TransactionTemplate(dataSourceTransactionManager);
    }
}