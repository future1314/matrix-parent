/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.sof;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.ConfigurableWebApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

/**
 * @author zyy43688
 * @version $Id: SOFContextLoaderListener.java, v 0.1 2018年5月21日 下午5:09:07 zyy43688 Exp $
 */
@Slf4j
public class SOFContextLoaderListener extends ContextLoaderListener {
    @Override
    protected void customizeContext(ServletContext sc, ConfigurableWebApplicationContext wac) {
        super.customizeContext(sc, wac);
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        log.info("Launching SOF application >>>");

        // 加载Spring容器
        super.contextInitialized(event);

        try{

        }catch (Exception e){

            ContextLoader.getCurrentWebApplicationContext().getBean("");
            throw new RuntimeException(e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        super.contextDestroyed(event);
    }
}