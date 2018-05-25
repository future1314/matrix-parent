/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.sof;

import java.util.Map;

/**
 * @author zyy43688
 * @version $Id: AppConfiguration.java, v 0.1 2018年5月21日 下午5:59:40 zyy43688 Exp $
 */
public interface AppConfiguration {
    /** 系统主机名称 */
    String SYS_HOST_NAME       = "sys.host.name";

    /** 系统ip地址 */
    String SYS_IP              = "sys.ip";

    /** 应用名称 */
    String SYS_APP_NAME        = "app.name";

    /** 应用运行模式 */
    String SYS_RUN_MODE        = "sof-env";

    /** 消息命名服务器地址 */
    String MQ_NAME_SERVER_ADDR = "mq.namesrv.addr";

    /**
     * 获取应用配置信息
     */
    Map<String, String> getConfig();

    /**
     * 获取系统属性
     */
    String getPropertyValue(String key);

    /**
     *  获取系统参数，不存在则使用默认值
     *  
     * @param key
     * @param defaultValue
     * @return
     */
    String getPropertyValue(String key, String defaultValue);

    /**
     * 添加配置信息
     */
    void addProperty(String key, String value);

    /**
     * 获取应用名称
     */
    String getSysAppName();

    /**
     * 获取系统IP地址
     */
    String getSysIp();

    /**
     * 获取系统运行模式
     *
     * @return 系统运行模式
     */
    String getSysRunMode();

    /**
     * 获取系统主机名称
     *
     * @return 系统主机名称
     */
    String getSysHostName();
}