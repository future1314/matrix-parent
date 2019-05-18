/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.ioc.customer.parse;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * reference元素解析器
 *
 * @author zyy43688
 * @version $Id: ReferenceBeanDefinitionParse.java, v 0.1 2018年7月11日 上午10:31:36 zyy43688 Exp $
 */
public class ReferenceBeanDefinitionParse implements BeanDefinitionParser {

    /*bean类型*/
    private final Class<?> beanClass;

    public ReferenceBeanDefinitionParse(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    @Nullable
    @Override
    public BeanDefinition parse(Element element, ParserContext parserContext) {
        // 创建BeanDefinition的实例
        RootBeanDefinition beanDefinition = new RootBeanDefinition();

        beanDefinition.setBeanClass(this.beanClass);
        beanDefinition.setLazyInit(false);

        String id = element.getAttribute("id");

        if (!StringUtils.isEmpty(id)) {
            parserContext.getRegistry().registerBeanDefinition(id, beanDefinition);//
            beanDefinition.getPropertyValues().add("id", id);
        }

        String description = element.getAttribute("description");

        if (!StringUtils.isEmpty(description)) {
            beanDefinition.getPropertyValues().add("description", description);
        }

        return beanDefinition;
    }
}