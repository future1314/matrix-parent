package zhangyuyao.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author 张玉尧（matrix.zhang@ximalaya.com）
 * @version $Id: ServletDemo.java, v 0.1 2018年10月12日 下午2:19:20 张玉尧（matrix.zhang@ximalaya.com） Exp $
 */
@Slf4j
public class ServletDemo implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        log.info("Servlet.init is invoked！");
        log.info("Servlet.init is invoked！servletConfig hashCode: {}", servletConfig.hashCode());
        log.info("Servlet.init is invoked！servletContext hashCode: {}", servletConfig.getServletContext().hashCode());
        Enumeration<String> parameterNames = servletConfig.getInitParameterNames();
        while (parameterNames.hasMoreElements()) {
            log.info("Servlet.init is invoked！paramName:{}, paramValue:{}", servletConfig.getInitParameter(parameterNames.nextElement()));
        }
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        log.info("Servlet.service is invoked!, url={}", servletRequest.getLocalAddr());
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        log.info("Servlet.destroy is invoked!");
    }
}
