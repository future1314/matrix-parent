/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.zhangyuyao.springBoot.transaction.dal;

import com.zhangyuyao.springBoot.transaction.model.Counter;

/**
 * @author zyy43688
 * @version $Id: CountDAO.java, v 0.1 2018年3月30日 下午1:50:03 zyy43688 Exp $
 */
public interface CountDAO {
    /**
     * 账户新增金额
     *
     * @param counter 待处理账户
     * @param count   增加的金额
     * @return 受影响行数
     */
    int addCount(Counter counter, int count);

    /**
     * 账户减去金额
     *
     * @param counter 待处理账户
     * @param count   减少的金额
     * @return 受影响行数
     */
    int subCount(Counter counter, int count);
}