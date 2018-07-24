/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.ioc.annotation.bean;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * 女朋友
 *
 * @author zyy43688
 * @version $Id: Girlfriend.java, v 0.1 2018年7月24日 下午3:18:56 zyy43688 Exp $
 */
@Slf4j
@Component
public class Girlfriend {

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private int    age;

    public void angry() {
        log.info("女朋友生气啦！");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}