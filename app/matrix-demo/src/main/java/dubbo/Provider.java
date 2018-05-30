/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zyy43688
 * @version $Id: Provider.java, v 0.1 2018年5月25日 下午4:26:59 zyy43688 Exp $
 */
public class Provider {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "dubbo.xml" });
        context.start();
        // press any key to exit
//        System.in.read();
    }
}