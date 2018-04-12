/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.zhangyuyao.springBoot.transaction.biz.impl;

import com.zhangyuyao.springBoot.transaction.biz.CountService;
import com.zhangyuyao.springBoot.transaction.dal.CountDAO;
import com.zhangyuyao.springBoot.transaction.model.Counter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;

/**
 * @author zyy43688
 * @version $Id: CountServiceImpl.java, v 0.1 2018年3月30日 下午2:04:42 zyy43688 Exp $
 */
@Service
public class CountServiceImpl implements CountService {

    /**
     * 编程式事务管理
     */
    @Resource
    private TransactionTemplate transactionTemplate;

    /**
     * 账户DAO
     */
    @Resource
    private CountDAO countDAO;

    /**
     * 转账方法
     *
     * @param from  源账户
     * @param to    目标账户
     * @param count 转账金额
     */
    @Override
    public void transfer(Counter from, Counter to, int count) {
        System.out.println("transfer方法被调用！");
        // 转出账户
        countDAO.subCount(from, count);
        // 转入账户
        countDAO.addCount(to, count);
    }

    /**
     * 带事务管理的转账方法
     *
     * @param from  源账户
     * @param to    目标账户
     * @param count 转账金额
     */
    @Override
    public void transferWithTransaction(Counter from, Counter to, int count) {
        transactionTemplate.execute(transactionStatus -> {
            System.out.println("transfer方法被调用！");
            // 转出账户
            int result = countDAO.subCount(from, count);
            if (result > 0) {
                // 正常转出，模拟异常抛出
                //throw new RuntimeException("简单的测试而已！");
            }
            // 转入账户
            countDAO.addCount(to, count);
            return true;
        });
    }

    /**
     * 声明式事务实现
     *
     * @param from  源账户
     * @param to    目标账户
     * @param count 转账金额
     */
    @Override
    @Transactional(value = "dataSourceTransactionManager", rollbackFor = Exception.class)
    public void transferWithTransactionByAnnotation(Counter from, Counter to, int count) throws Exception {
        System.out.println("transfer方法被调用！");
        // 转出账户
        int result = countDAO.subCount(from, count);
        if (result > 0) {
            // 正常转出，模拟异常抛出
            throw new Exception("简单的测试而已！");
        }
        // 转入账户
        countDAO.addCount(to, count);
    }
}


// 下面这段代码是垃圾代码
class MyTransactionCallback<T> implements TransactionCallback<T> {

    private Counter from;
    private Counter to;
    private int count;
    private CountDAO countDAO;


    @Nullable
    @Override
    public T doInTransaction(TransactionStatus transactionStatus) {
        System.out.println("transfer方法被调用！");
        // 转出账户
        int result = countDAO.subCount(from, count);
        if (result > 0) {
            // 正常转出，模拟异常抛出
            throw new RuntimeException("简单的测试而已！");
        }
        // 转入账户
        countDAO.addCount(to, count);
        return null;
    }

    public MyTransactionCallback(CountDAO countDAO, Counter from, Counter to, int count) {
        this.countDAO = countDAO;
        this.from = from;
        this.to = to;
        this.count = count;
    }
}