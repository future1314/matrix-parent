/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.ioc.customer;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

import zhangyuyao.ioc.customer.bean.Reference;
import zhangyuyao.ioc.customer.parse.ReferenceBeanDefinitionParse;

/**
 * 命名空间处理器
 * 
 * 一个NamespaceHandlerSupport对应一个schema
 *
 * @author zyy43688
 * @version $Id: CustomerNamespaceHandler.java, v 0.1 2018年7月11日 上午10:27:27 zyy43688 Exp $
 */
public class CustomerNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        // 元素解析器
        registerBeanDefinitionParser("reference", new ReferenceBeanDefinitionParse(Reference.class));
    }
}