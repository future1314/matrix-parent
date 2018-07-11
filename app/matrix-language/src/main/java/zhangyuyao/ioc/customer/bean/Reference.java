/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.ioc.customer.bean;

/**
 * 应用
 *
 * @author zyy43688
 * @version $Id: Reference.java, v 0.1 2018年7月11日 上午10:47:05 zyy43688 Exp $
 */
public class Reference {

    /**
     * id
     */
    private String id;

    /**
     * 描述
     */
    private String description;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Reference{");
        sb.append("id='").append(id).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}