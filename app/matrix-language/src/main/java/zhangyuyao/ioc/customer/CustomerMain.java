/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.ioc.customer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;
import zhangyuyao.ioc.customer.bean.GirlFactoryBean;
import zhangyuyao.ioc.customer.bean.Girl;
import zhangyuyao.ioc.customer.bean.Me;
import zhangyuyao.ioc.customer.bean.Reference;

/**
 * @author zyy43688
 * @version $Id: CustomerMain.java, v 0.1 2018年7月11日 上午10:50:26 zyy43688 Exp $
 */
@Slf4j
public class CustomerMain {

    public static void main(String[] args) {

        // 载入XML配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:CustomerMain.xml");

        Reference reference = (Reference) context.getBean("matrix");

        Me me = (Me) context.getBean("me");

        GirlFactoryBean girlFactoryBean = (GirlFactoryBean) context.getBean("&girl");//取得factoryBean

        Girl girl = (Girl) context.getBean("girl");

        Girl copyGirl = (Girl) context.getBean("girl");
        log.info("me={}",me);
        log.info("reference={}",reference.toString());
        log.info("girlFactoryBean={}",girlFactoryBean);
        log.info("girl={},copyGirl={},{}",girl,copyGirl,girl.equals(copyGirl));
    }
}