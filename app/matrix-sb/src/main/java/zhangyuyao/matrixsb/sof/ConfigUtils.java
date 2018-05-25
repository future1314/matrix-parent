/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.sof;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zyy43688
 * @version $Id: ConfigUtils.java, v 0.1 2018年5月22日 下午1:43:38 zyy43688 Exp $
 */
@Slf4j
public class ConfigUtils {

    private static volatile Properties properties;

    public static Properties getProperties() {
        if (properties == null) {
            synchronized (ConfigUtils.class) {
                if (properties == null) {
                    String path = System.getProperty(Constants.DUBBO_PROPERTIES_KEY);// 获取所谓的文件属性
                    if (path == null || path.length() == 0) {
                        path = System.getenv(Constants.DUBBO_PROPERTIES_KEY);
                        if (path == null || path.length() == 0) {
                            path = Constants.DEFAULT_DUBBO_PROPERTIES;
                        }
                    }

                    properties = ConfigUtils.loadProperties(path, false, true);
                }
            }
        }
        return properties;
    }

    public static Properties loadProperties(String fileName, boolean allowMultiFile, boolean optional) {
        Properties properties = new Properties();

        if (fileName.startsWith("/")) {
            try {
                FileInputStream input = new FileInputStream(fileName);

                try {
                    properties.load(input);
                } finally {
                    input.close();
                }

            } catch (Throwable e) {
                log.warn("Failed to load " + fileName + " file from " + fileName + "(ingore this file): " + e.getMessage(), e);
            }

            return properties;
        }

        List<URL> list = new ArrayList<>();

        try {
            Enumeration<URL> urls = ClassHelper.getClassLoader().getResources(fileName);

            list = new ArrayList<>();

            while (urls.hasMoreElements()) {
                list.add(urls.nextElement());
            }
        } catch (Throwable t) {
            log.warn("Fail to load " + fileName + " file: " + t.getMessage(), t);
        }

        if (list.size() == 0) {
            if (!optional) {
                log.warn("No " + fileName + " found on the class path.");
            }

            return properties;
        }

        if (!allowMultiFile) {
            if (list.size() > 1) {
                String errMsg = String.format("only 1 %s file is expected, but %d dubbo.properties files found on class path: %s", fileName, list.size(), list.toString());
                log.warn(errMsg);
            }

            try {
                properties.load(ClassHelper.getClassLoader().getResourceAsStream(fileName));
            } catch (Throwable e) {
                log.warn("Failed to load " + fileName + " file from " + fileName + "(ingore this file): " + e.getMessage(), e);
            }

            return properties;
        }

        for (URL url : list) {
            try {
                Properties p = new Properties();
                InputStream input = url.openStream();

                if (input != null) {
                    try {
                        p.load(input);
                        properties.putAll(p);
                    } finally {
                        try {
                            input.close();
                        } catch (Throwable t) {

                        }
                    }
                }
            } catch (Throwable e) {
                log.warn("Fail to load " + fileName + " file from " + url + "(ingore this file): " + e.getMessage(), e);
            }
        }

        return properties;
    }
}