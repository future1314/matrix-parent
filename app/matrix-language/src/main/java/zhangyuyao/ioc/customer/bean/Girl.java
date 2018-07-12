/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.ioc.customer.bean;

import lombok.extern.slf4j.Slf4j;

/**
 * 用来测试FactoryBean
 * 
 * @author zyy43688
 * @version $Id: Girl.java, v 0.1 2018年7月12日 下午1:53:09 zyy43688 Exp $
 */
@Slf4j
public class Girl {
    private String name;

    private String height;

    private String weight;

    private String bb;

    public Girl(String name, String height, String weight, String bb) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.bb = bb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBb() {
        return bb;
    }

    public void setBb(String bb) {
        this.bb = bb;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Girl{");
        sb.append("name='").append(name).append('\'');
        sb.append(", height='").append(height).append('\'');
        sb.append(", weight='").append(weight).append('\'');
        sb.append(", bb='").append(bb).append('\'');
        sb.append('}');
        return sb.toString();
    }
}