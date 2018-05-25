/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.filter;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;
import zhangyuyao.matrixsb.biz.RequestThreadHandler;

/**
 * @author zyy43688
 * @version $Id: ThreadIdHandler.java, v 0.1 2018年5月11日 上午10:36:40 zyy43688 Exp $
 */
@Slf4j
public class ThreadIdFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        log.info("进入filter方法，设置线程id为{}", Thread.currentThread().getId());
        log.info("请求地址getRemoteAddr为：{}", httpServletRequest.getRemoteAddr());
        log.info("请求地址getRemoteHost为：{}", httpServletRequest.getRemoteHost());
        log.info("请求地址getRemotePort为：{}", httpServletRequest.getRemotePort());
        RequestThreadHandler.set(Thread.currentThread().getId());
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}