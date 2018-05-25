/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.customer;

/**
 * @author zyy43688
 * @version $Id: Matrix.java, v 0.1 2018年5月18日 下午4:56:23 zyy43688 Exp $
 */
public class Matrix {

    protected String id;

    /**
     * 描述
     */
    private String   description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}