/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author zyy43688
 * @version $Id: Matrix.java, v 0.1 2018年6月25日 下午2:52:28 zyy43688 Exp $
 */
@Component
@PropertySource("classpath:placeholder.properties")
public class Matrix {

    @Value("${name}")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}