/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.zhangyuyao.springBoot.transaction.dal.impl;

import com.zhangyuyao.springBoot.transaction.dal.CountDAO;
import com.zhangyuyao.springBoot.transaction.model.Counter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author zyy43688
 * @version $Id: CountDAOImpl.java, v 0.1 2018年3月30日 下午1:54:54 zyy43688 Exp $
 */
@Component
public class CountDAOImpl implements CountDAO {
    /**
     *
     */
    @Resource
    JdbcTemplate jdbcTemplate;

    /**
     * 账户新增金额
     *
     * @param counter 待处理账户
     * @param count   增加的金额
     * @return 受影响行数
     */
    @Override
    public int addCount(Counter counter, int count) {
        System.out.println("新增金额被调用！");
        int result = jdbcTemplate.update("UPDATE SPRING_TRANSACTION SET MONEY = MONEY + ? WHERE NAME = ?", count, counter.getName());
        System.out.println("新增金额调用结束！");
        return result;
    }

    /**
     * 账户减去金额
     *
     * @param counter 待处理账户
     * @param count   减少的金额
     * @return 受影响行数
     */
    @Override
    public int subCount(Counter counter, int count) {
        System.out.println("减少金额被调用！");
        int result = addCount(counter, -count);
        System.out.println("减少金额调用结束！");
        return result;
    }
}