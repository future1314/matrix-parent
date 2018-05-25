/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.classload;

import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zyy43688
 * @version $Id: Demo.java, v 0.1 2018年5月17日 下午5:45:45 zyy43688 Exp $
 */
@Slf4j
public class Demo {
    public static void main(String[] args) {
        ClassLoader classLoader = new MyClassLoad();
        try {
            Class<?> clazz = classLoader.loadClass("com.ly.flight.tmc.tmcitineraryapi.biz.Demo");

            ClassLoader loader = clazz.getClassLoader();

            log.info("start...");

            log.info("{}", loader.getResource("test.zyy"));
            log.info("{}", loader.getResources("test.zyy"));
            log.info("{}", loader.getResourceAsStream("test.zyy"));

            log.info("end...");

            while (loader != null) {
                log.info("ClassLoad is {}", loader);
                loader = loader.getParent();
            }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
}