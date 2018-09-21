/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.zhangyuyao.remote.controller;

import com.zhangyuyao.remote.biz.DemoService;
import com.zhangyuyao.remote.biz.RequestThreadHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author zyy43688
 * @version $Id: DemoController.java, v 0.1 2018年5月10日 下午7:48:57 zyy43688 Exp $
 */
@RequestMapping("/demo")
@Controller
@Slf4j
public class DemoController {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Resource
    DemoService demoService;

    @RequestMapping(value = "/enter", method = {RequestMethod.POST})
    @ResponseBody
    public String enter() {
        demoService.increment();
        return "This is a test!";
    }

    @RequestMapping(value = "/get", method = {RequestMethod.POST})
    @ResponseBody
    public int get() {
        return demoService.get();
    }

    @RequestMapping(value = "/reset", method = {RequestMethod.POST})
    @ResponseBody
    public int reset(@RequestParam(value = "num") int num) {
        return demoService.resetToNum(num);
    }

    private static int count;

    @RequestMapping(value = "/test", method = {RequestMethod.POST})
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

    @GetMapping("/mq")
    @ResponseBody
    public boolean mq() {
        amqpTemplate.convertAndSend("openapi.tag.delete.exchange.fanout", "", "matrix");
        return true;
    }
}