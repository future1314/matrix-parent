/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.value;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zyy43688
 * @version $Id: ValueDemo.java, v 0.1 2018年6月25日 下午2:51:03 zyy43688 Exp $
 */
public class ValueDemo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "classpath:value.xml" }, true, null);

        Matrix matrix = (Matrix) context.getBean("matrix");

        System.out.println(matrix.getName());
    }
}