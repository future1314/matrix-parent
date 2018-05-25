/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.sof;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.ManagedMap;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/**
 * @author zyy43688
 * @version $Id: DubboBeanDefinitionParser.java, v 0.1 2018年5月21日 下午3:40:21 zyy43688 Exp $
 */
public class DubboBeanDefinitionParser implements BeanDefinitionParser {

    /**
     * 要解析的bean的类型
     */
    private final Class<?> beanClass;

    /**
     * 是否是必须的
     */
    private final boolean  required;

    /**
     * 带参构造函数
     * 
     * @param beanClass class
     * @param required 是否必须的
     */
    public DubboBeanDefinitionParser(Class<?> beanClass, boolean required) {
        this.beanClass = beanClass;
        this.required = required;
    }

    @Override
    public BeanDefinition parse(Element element, ParserContext parserContext) {
        return parse(element, parserContext, beanClass, required);
    }

    /**
     * 
     * @param element
     * @param parserContext
     * @param beanClass
     * @param required
     * @return
     */
    private static BeanDefinition parse(Element element, ParserContext parserContext, Class<?> beanClass, boolean required) {
        // 为什么要声明为RootBeanDefinition类型的实例
        RootBeanDefinition beanDefinition = new RootBeanDefinition();

        beanDefinition.setBeanClass(beanClass);
        beanDefinition.setLazyInit(false);

        // 取出ID
        String id = element.getAttribute("id");

        if ((id == null || id.length() == 0) && required) {
            // 必须但是ID没有值

            // 查找是不是定义了name属性
            String generateBeanName = element.getAttribute("name");

            if (generateBeanName == null || generateBeanName.length() == 0) {
                // generateBeanName不存在
                if (ProtocolConfig.class.equals(beanClass)) {
                    generateBeanName = "dubbo";
                } else {
                    generateBeanName = element.getAttribute("interface");
                }
            }

            if (generateBeanName == null || generateBeanName.length() == 0) {
                generateBeanName = beanClass.getName();
            }

            id = generateBeanName;

            int counter = 2;

            // 这里这一句是干嘛用的？简直尴尬！
            while (parserContext.getRegistry().containsBeanDefinition(id)) {
                id = generateBeanName + (counter++);
            }

            if (id.length() > 0) {
                if (parserContext.getRegistry().containsBeanDefinition(id)) {
                    throw new IllegalStateException("Duplicate spring bean id " + id);
                }

                parserContext.getRegistry().registerBeanDefinition(id, beanDefinition);
                beanDefinition.getPropertyValues().add("id", id);
            }

            if (ProtocolConfig.class.equals(beanClass)) {
                for (String name : parserContext.getRegistry().getBeanDefinitionNames()) {
                    BeanDefinition definition = parserContext.getRegistry().getBeanDefinition(name);

                    PropertyValue property = definition.getPropertyValues().getPropertyValue("protocol");

                    if (property != null) {
                        Object value = property.getValue();

                        if (value instanceof ProtocolConfig && id.equals(((PropertyValue) value).getName())) {
                            definition.getPropertyValues().addPropertyValue("protocol", new RuntimeBeanReference(id));
                        }
                    }
                }
            } else if (ServiceBean.class.equals(beanClass)) {
                String className = element.getAttribute("class");
                if (className != null && className.length() > 0) {
                    RootBeanDefinition classDefinition = new RootBeanDefinition();
                    classDefinition.setLazyInit(false);
                    classDefinition.setBeanClass(beanClass);

                    // todo
                    beanDefinition.getPropertyValues().addPropertyValue("ref", new BeanDefinitionHolder(classDefinition, id + "impl"));
                }
            } else if (ProviderConfig.class.equals(beanClass)) {
                // todo
            } else if (ConsumerConfig.class.equals(beanClass)) {
                // todo
            }

            Set<String> props = new HashSet<>();

            ManagedMap parameters = null;

            for (Method setter : beanClass.getMethods()) {
                String name = setter.getName();

                if (name.length() > 3 && name.startsWith("set") && Modifier.isPublic(setter.getModifiers()) && setter.getParameterTypes().length == 1) {

                    Class<?> type = setter.getParameterTypes()[0];

                    String property = StringUtils.camelToSplitName(name.substring(3, 4).toLowerCase() + name.substring(4), "-");

                    props.add(property);

                    Method getter = null;

                    try {
                        getter = beanClass.getMethod("get" + name.substring(3), new Class<?>[0]);
                    } catch (NoSuchMethodException e) {
                        try {
                            getter = beanClass.getMethod("is" + name.substring(3), new Class<?>[0]);
                        } catch (NoSuchMethodException e2) {
                        }
                    }

                    if (getter == null || !Modifier.isPublic(getter.getModifiers()) || !type.equals(getter.getReturnType())) {
                        continue;
                    }

                    if ("parameters".equals(property)) {
                        // todo
                    } else if ("methods".equals(property)) {
                        // todo
                    } else if ("arguments".equals(property)) {
                        // todo
                    } else {
                        String value = element.getAttribute(property);

                        if (value != null) {
                            value = value.trim();

                            if (value.length() > 0) {
                                if ("registry".equals(property)) {
                                    // todo
                                } else if ("provider".equals(property)) {
                                    // todo
                                } else {
                                    Object reference;
                                    if (isPrimitive(type)) {
                                        if ("async".equals(property) && "false".equals(value)) {
                                            // value
                                            // todo
                                        }
                                        reference = null;
                                    }

                                }
                            }
                        }
                    }
                }
            }
        }

        NamedNodeMap attributes = element.getAttributes();

        int len = attributes.getLength();

        for (int i = 0; i < len; i++) {
            Node node = attributes.item(i);

            String name = node.getLocalName();
        }

        return null;
    }

    private static boolean isPrimitive(Class<?> type) {
        return (type.isPrimitive() || Byte.class.equals(type) || Character.class.equals(type) || Short.class.equals(type) || Integer.class.equals(type) || Long.class.equals(type)
                || Float.class.equals(type) || Double.class.equals(type) || String.class.equals(type) || Class.class.equals(type));
    }
}