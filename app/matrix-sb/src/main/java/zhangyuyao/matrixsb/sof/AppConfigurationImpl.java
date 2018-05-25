/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.sof;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author zyy43688
 * @version $Id: AppConfigurationImpl.java, v 0.1 2018年5月22日 下午3:34:52 zyy43688 Exp $
 */
public class AppConfigurationImpl implements AppConfiguration {

    /** 系统变量的前缀 */
    private static final String SYSTEM_PROPERTY_PREFIX = "__sof__";

    /** 系统内部配置 */
    private Map<String, String> internalConfig         = new LinkedHashMap<String, String>();

    /** 应用配置 */
    private Map<String, String> appConfig              = new LinkedHashMap<String, String>();

    /**
     * 默认构造函数
     */
    public AppConfigurationImpl() {
        loadSystemConfig();
    }

    public AppConfigurationImpl(Map<String, String> appConfig) {
        this.appConfig = appConfig;
        loadSystemConfig();
    }

    /**
     * 加载系统配置
     */
    private void loadSystemConfig() {
        Properties properties = System.getProperties();

        if (properties == null) {
            return;
        }

        for (Object key : properties.keySet()) {
            String name = key.toString().trim();

            if (name.length() == 0) {
                continue;
            }

            if (name.startsWith(SYSTEM_PROPERTY_PREFIX)) {
                String value = properties.get(key).toString().trim();

                String shortKey = name.substring(SYSTEM_PROPERTY_PREFIX.length());
                internalConfig.put(shortKey, value);
            }
        }
    }

    @Override
    public Map<String, String> getConfig() {
        return null;
    }

    @Override
    public String getPropertyValue(String key) {
        return null;
    }

    @Override
    public String getPropertyValue(String key, String defaultValue) {
        return null;
    }

    @Override
    public void addProperty(String key, String value) {

    }

    @Override
    public String getSysAppName() {
        return null;
    }

    @Override
    public String getSysIp() {
        return null;
    }

    @Override
    public String getSysRunMode() {
        return null;
    }

    @Override
    public String getSysHostName() {
        return null;
    }
}