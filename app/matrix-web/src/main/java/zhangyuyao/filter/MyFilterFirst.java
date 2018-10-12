package zhangyuyao.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author 张玉尧（matrix.zhang@ximalaya.com）
 * @version $Id: MyFilterFirst.java, v 0.1 2018年10月12日 下午2:53:42 张玉尧（matrix.zhang@ximalaya.com） Exp $
 */
@Slf4j
public class MyFilterFirst implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init method of first filter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("doFilter method of first filter");
    }

    @Override
    public void destroy() {
        log.info("destroy method of first filter");
    }
}
