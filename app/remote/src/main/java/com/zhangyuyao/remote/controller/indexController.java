package com.zhangyuyao.remote.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 张玉尧（matrix.zhang@ximalaya.com）
 * @version $Id: indexController.java, v 0.1 2018年10月9日 下午6:25:35 张玉尧（matrix.zhang@ximalaya.com） Exp $
 */
@Controller
public class indexController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}
