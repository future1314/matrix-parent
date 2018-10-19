package zhangyuyao.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author 张玉尧（matrix.zhang@ximalaya.com）
 * @version $Id: MyListenerSecond.java, v 0.1 2018年10月19日 上午11:33:28 张玉尧（matrix.zhang@ximalaya.com） Exp $
 */

@WebListener
@Slf4j
public class MyListenerSecond implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("MyListenerSecond.contextInitialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("MyListenerSecond.contextDestroyed");
    }
}
