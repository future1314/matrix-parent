/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;
import zhangyuyao.matrixsb.biz.RequestThreadHandler;

/**
 * @author zyy43688
 * @version $Id: MyInterceptor.java, v 0.1 2018年5月11日 下午1:55:06 zyy43688 Exp $
 */
@Slf4j
public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        log.info("after方法被执行，线程id为{}，ThreadLocal取出来的值为{}", Thread.currentThread().getId(), RequestThreadHandler.get());
        RequestThreadHandler.remove();
        log.info("线程ID已经被移除，ThreadLocal返回值为{}", RequestThreadHandler.get());
    }
}