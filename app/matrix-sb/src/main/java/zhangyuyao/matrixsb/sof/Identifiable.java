/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.sof;

import java.io.Serializable;

import org.apache.commons.collections4.Transformer;

/**
 * 实体ID领域模型，所有业务领域模型应实现该接口，提供ID的获取和设置功能
 * 
 * @author zyy43688
 * @version $Id: Identifiable.java, v 0.1 2018年5月22日 下午5:43:18 zyy43688 Exp $
 */
public interface Identifiable<ID extends Serializable> extends Serializable {
    /**
     * 获取领域模型ID
     *
     * @return
     */
    ID getId();

    /**
     * 设置领域模型ID
     *
     * @param id
     */
    void setId(ID id);

    Transformer TRANSFORMER = new Transformer() {
        @Override
        public Object transform(Object id) {
            return ((Identifiable<Serializable>) id).getId();
        }
    };
}