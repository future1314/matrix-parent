/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.customer;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author zyy43688
 * @version $Id: MatrixNamespaceHandler.java, v 0.1 2018年5月18日 下午4:42:35 zyy43688 Exp $
 */
public class MatrixNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("matrix", new MatrixBeanDefinitionParser(Matrix.class, true));
    }
}