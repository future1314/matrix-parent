package zhangyuyao.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

        for (Cookie cookie : cookies) {
            log.info("cookie's name is {}, cookie's value is {}", cookie.getName(), cookie.getValue());
        }

        // add a cookie

        resp.addCookie(new Cookie("username", "matrix"));
    }
}
