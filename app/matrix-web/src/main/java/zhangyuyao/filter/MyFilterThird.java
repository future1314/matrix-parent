package zhangyuyao.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author 张玉尧（matrix.zhang@ximalaya.com）
 * @version $Id: MyFilterThird.java, v 0.1 2018年10月12日 下午2:54:22 张玉尧（matrix.zhang@ximalaya.com） Exp $
 */
@Slf4j
public class MyFilterThird implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init method of third filter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("doFilter method of third filter");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        log.info("destroy method of third filter");
    }
}
