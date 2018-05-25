/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.sof;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zyy43688
 * @version $Id: DefaultSOFContext.java, v 0.1 2018年5月21日 下午6:06:31 zyy43688 Exp $
 */
@Slf4j
public class DefaultSOFContext implements SOFContext, ApplicationContextAware, BeanPostProcessor, DsfLoadListener {

    private static final String EVENT_MULTICASTER_NAME = "eventMulticaster";

    /**
     * 容器ID
     */
    private String              id;

    /**
     * 容器实例名称
     */
    private String              contextName;

    /**
     * 容器启动时间
     */
    private long                startupDate;

    /**
     * Spring 上下文
     */
    private ApplicationContext  springContext;

    /**
     * 容器运行状态
     */
    private boolean             running;

    /**
     * 事件派发器
     */
    private EventMulticaster    eventMulticaster;

    /**
     * 应用配置信息
     */
    private AppConfiguration    appConfiguration;

    /**
     * 构造函数
     */
    public DefaultSOFContext() {
        this.id = this.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(this));
        this.startupDate = System.currentTimeMillis();
        this.appConfiguration = loadConfiguration();
    }

    protected AppConfiguration loadConfiguration() {
        Properties props = ConfigUtils.getProperties();
        AppConfiguration configuration = new AppConfigurationImpl((Map) props);
        configuration.addProperty(AppConfiguration.SYS_IP, IpUtils.getLocalHostIp());
        configuration.addProperty(AppConfiguration.SYS_HOST_NAME, IpUtils.getLocalHostName());
        printConfiguration(configuration);
        return configuration;
    }

    /**
     * 输出配置信息
     *
     * @param conf
     */
    private void printConfiguration(AppConfiguration conf) {
        for (Map.Entry<String, String> prop : conf.getConfig().entrySet()) {
            log.info("Application configuration:{}={}", prop.getKey(), prop.getValue());
        }
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public String getAppName() {
        return null;
    }

    @Override
    public String getContextName() {
        return null;
    }

    @Override
    public long getStartupDate() {
        return 0;
    }

    @Override
    public synchronized boolean init() {
        if (running) {
            log.info("");
            return running;
        }

        try {

            initialize();// 初始化操作
            setupSOFContext();// 容器启动感知
            registerListener();// 注册监听器
            onContextStartup();// 启动后处理事件，事件带优先级
            onProducerStartup();// 执行生产者启动
            onConsumerStartup();// 执行消费者启动

        } catch (Exception e) {
            running = false;
        }

        return running;
    }

    private void onConsumerStartup() {
    }

    private void onProducerStartup() {
        log.info("");
    }

    private void onContextStartup() {
        log.info("");
        Map<String, StartupCallback> beans = springContext.getBeansOfType(StartupCallback.class, false, true);

        if (beans != null) {
            List<StartupCallback> callbacks = new ArrayList<>();

            callbacks.addAll(beans.values());

            callbacks.sort((o1, o2) -> {
                if (o1.getOrder() == o2.getOrder()) {
                    return 0;
                } else if (o1.getOrder() > o2.getOrder()) {
                    return 1;
                } else {
                    return -1;
                }
            });

            for (StartupCallback bean : callbacks) {
                log.info("");
                bean.startup(this);
            }
        }

    }

    private void setupSOFContext() {
        log.info("");
        Map<String, SOFContextAware> beans = springContext.getBeansOfType(SOFContextAware.class, false, true);
        if (beans != null) {
            for (SOFContextAware bean : beans.values()) {
                log.info("");
                bean.setSOFContext(this);
            }
        }
    }

    /**
     * 执行容器初始化
     */
    private void initialize() {
        log.info("");
        Map<String, SOFContextInitializationAware> beans = springContext.getBeansOfType(SOFContextInitializationAware.class, false, true);

        if (beans != null) {
            for (SOFContextInitializationAware bean : beans.values()) {
                log.info("");
                bean.init();
            }
        }
    }

    @Override
    public void shutdown() {

    }

    @Override
    public boolean isRunning() {
        return false;
    }

    @Override
    public void fireEvent(BaseEvent event, boolean sync) {

    }

    @Override
    public EventMulticaster getEventMulticaster() {
        return null;
    }

    @Override
    public void setEventMulticaster(EventMulticaster eventMulticaster) {

    }

    @Override
    public AppConfiguration getAppConfiguration() {
        return null;
    }

    @Override
    public void registerListener() {
        log.info("");
        Map<String, BaseListener> beans = springContext.getBeansOfType(BaseListener.class, false, true);

        if (beans != null) {
            for (BaseListener bean : beans.values()) {
                log.info("");
                getEventMulticaster().addListener(bean);
            }
        }
    }

    @Override
    public void registerListener(BaseListener<BaseEvent> listener) {

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}