/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.customer;

import org.springframework.beans.factory.BeanNameAware;

import lombok.extern.slf4j.Slf4j;

/**
 * 职工
 *
 * @author zyy43688
 * @version $Id: Staff.java, v 0.1 2018年7月6日 上午10:10:07 zyy43688 Exp $
 */
@Slf4j
public class Staff implements BeanNameAware {

    /**
     * 职工名称
     */
    private String staffName;

    @Override
    public void setBeanName(String name) {
        staffName = name;
        log.info("staffName is {}", name);
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }
}