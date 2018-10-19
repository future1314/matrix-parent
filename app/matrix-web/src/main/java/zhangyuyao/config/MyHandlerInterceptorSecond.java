package zhangyuyao.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 张玉尧（matrix.zhang@ximalaya.com）
 * @version $Id: MyHandlerInterceptorSecond.java, v 0.1 2018年10月18日 下午4:35:38 张玉尧（matrix.zhang@ximalaya.com） Exp $
 */
@Slf4j
public class MyHandlerInterceptorSecond implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("MyHandlerInterceptorSecond.preHandle");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("MyHandlerInterceptorSecond.postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("MyHandlerInterceptorSecond.afterCompletion");
    }
}