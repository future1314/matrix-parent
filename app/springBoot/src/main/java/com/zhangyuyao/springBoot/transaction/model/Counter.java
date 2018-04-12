/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.zhangyuyao.springBoot.transaction.model;

/**
 * @author zyy43688
 * @version $Id: Counter.java, v 0.1 2018年3月30日 下午1:51:54 zyy43688 Exp $
 */
public class Counter {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 金额
     */
    private Integer money;

    public Counter() {
    }

    public Counter(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }
}