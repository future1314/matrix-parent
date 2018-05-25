/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import zhangyuyao.matrixsb.biz.DemoService;
import zhangyuyao.matrixsb.biz.RequestThreadHandler;

/**
 * @author zyy43688
 * @version $Id: DemoController.java, v 0.1 2018年5月10日 下午7:48:57 zyy43688 Exp $
 */
@RequestMapping("/demo")
@Controller
@Slf4j
public class DemoController {

    @Resource
    DemoService demoService;

    @RequestMapping(value = "/enter", method = { RequestMethod.POST })
    @ResponseBody
    public String enter() {
        demoService.increment();
        return "This is a test!";
    }

    @RequestMapping(value = "/get", method = { RequestMethod.POST })
    @ResponseBody
    public int get() {
        return demoService.get();
    }

    @RequestMapping(value = "/reset", method = { RequestMethod.POST })
    @ResponseBody
    public int reset(@RequestParam(value = "num") int num) {
        return demoService.resetToNum(num);
    }

    private static int count;

    @RequestMapping(value = "/test", method = { RequestMethod.POST })
    @ResponseBody
    public String test() {
        log.info("this is {} invoke！", count++);
        return "This is a test!";
    }

    @RequestMapping(value = "/threadLocal")
    @ResponseBody
    public int threadLocal() {
        return RequestThreadHandler.getHashCode();
    }
}