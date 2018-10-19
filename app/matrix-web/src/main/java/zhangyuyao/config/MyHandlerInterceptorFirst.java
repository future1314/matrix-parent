package zhangyuyao.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 张玉尧（matrix.zhang@ximalaya.com）
 * @version $Id: MyHandlerInterceptorFirst.java, v 0.1 2018年10月18日 上午11:53:26 张玉尧（matrix.zhang@ximalaya.com） Exp $
 */
@Slf4j
public class MyHandlerInterceptorFirst extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info("MyHandlerInterceptorFirst.preHandle");

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("MyHandlerInterceptorFirst.postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("MyHandlerInterceptorFirst.afterCompletion");
    }
}
