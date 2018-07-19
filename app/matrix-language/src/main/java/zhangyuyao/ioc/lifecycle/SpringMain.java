/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.ioc.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;
import zhangyuyao.ioc.lifecycle.bean.Person;
import zhangyuyao.ioc.lifecycle.bean.Staff;

/**
 * @author zyy43688
 * @version $Id: SpringMain.java, v 0.1 2018年7月6日 下午3:42:08 zyy43688 Exp $
        */
@Slf4j
public class SpringMain {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        testCreateSingletonInstance();
    }

    /**
     * 寻找单例模式下各个感知接口的调用时间和调用点
     */
    public static void wife() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:Wife.xml");
    }

    /**
     * 单例模式和原型模式的比较
     */
    public static void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:SpringMain.xml");

        Staff staff = (Staff) context.getBean("zhangyuyao.ioc.lifecycle.bean.Staff#0");

        Person person = (Person) context.getBean("person");
    }

    /**
     * 测试容器关闭时bean的生命周期
     */
    public static void testClose() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:Wife.xml");
        log.info("bean加载结束！");
        log.info("bean关闭开始！");
        context.close();
        log.info("bean关闭结束！");
    }

    /**
     * 测试懒加载
     */
    public static void testLazyLoad() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:lazyLoad.xml");
        log.info("获取bean！");
    }

    /**
     * 测试单例是什么时候加载到单例缓存中去的
     */
    public static void testCreateSingletonInstance() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:testCreateSingletonInstance.xml");
        context.getBean("wife");
    }
}