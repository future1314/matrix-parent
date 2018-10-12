package zhangyuyao.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author 张玉尧（matrix.zhang@ximalaya.com）
 * @version $Id: AnotherServletDemo.java, v 0.1 2018年10月12日 下午5:07:10 张玉尧（matrix.zhang@ximalaya.com） Exp $
 */
@Slf4j
public class AnotherServletDemo implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        log.info("AnotherServletDemo.init is invoked！");
        log.info("AnotherServletDemo.init is invoked！servletConfig hashCode: {}", servletConfig.hashCode());
        log.info("AnotherServletDemo.init is invoked！servletContext hashCode: {}", servletConfig.getServletContext().hashCode());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
