package zhangyuyao.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author 张玉尧（matrix.zhang@ximalaya.com）
 * @version $Id: MyApplicationListener.java, v 0.1 2018年10月18日 下午5:34:02 张玉尧（matrix.zhang@ximalaya.com） Exp $
 */
@Slf4j
@Component
public class MyApplicationListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        log.info("MyApplicationListener.onApplicationEvent");
    }
}
