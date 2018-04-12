/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.zhangyuyao.springBoot.transaction.biz;

import com.zhangyuyao.springBoot.transaction.model.Counter;

/**
 * @author zyy43688
 * @version $Id: CountService.java, v 0.1 2018年3月30日 下午1:49:47 zyy43688 Exp $
 */
public interface CountService {
    /**
     * 转账方法
     *
     * @param from  源账户
     * @param to    目标账户
     * @param count 转账金额
     */
    void transfer(Counter from, Counter to, int count);

    /**
     * 带事务管理的转账方法
     *
     * @param from  源账户
     * @param to    目标账户
     * @param count 转账金额
     */
    void transferWithTransaction(Counter from, Counter to, int count);

    /**
     * 声明式事务实现
     *
     * @param from  源账户
     * @param to    目标账户
     * @param count 转账金额
     */
    void transferWithTransactionByAnnotation(Counter from, Counter to, int count) throws Exception;
}