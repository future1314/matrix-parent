package zhangyuyao.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author 张玉尧（matrix.zhang@ximalaya.com）
 * @version $Id: MyListener.java, v 0.1 2018年10月12日 下午2:56:10 张玉尧（matrix.zhang@ximalaya.com） Exp $
 */
@Slf4j
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("contextInitialized method of MyListener!");
        log.info("contextInitialized method of MyListener! servletContext: {}", sce.getServletContext().hashCode());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("contentDestroyed method of MyListener!");
    }
}
