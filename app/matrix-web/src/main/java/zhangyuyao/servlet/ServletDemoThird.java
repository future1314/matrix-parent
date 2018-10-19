package zhangyuyao.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author 张玉尧（matrix.zhang@ximalaya.com）
 * @version $Id: ServletDemoThird.java, v 0.1 2018年10月19日 下午2:49:46 张玉尧（matrix.zhang@ximalaya.com） Exp $
 */
@Slf4j
public class ServletDemoThird extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getOutputStream().print("are you ok?");
        log.info("cookies");

        Cookie[] cookies = req.getCookies();

        if(cookies != null){
            for (Cookie cookie : cookies) {
                log.info("cookie's name is {}, cookie's value is {}", cookie.getName(), cookie.getValue());
            }
        }

        // add a cookie

        resp.addCookie(new Cookie("username", "matrix"));

        HttpSession session = req.getSession();

        log.info("session's id {}", session.getId());

        // 居然没有方法可以获取超时时间的配置
        // log.info("session's id {}, {}", session.getId(), req.getServletContext().getSessionTimeout());
    }
}
