/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.proxy.still;

/**
 * @author zyy43688
 * @version $Id: OriginClass.java, v 0.1 2018年4月12日 下午3:37:22 zyy43688 Exp $
 */
public class OriginClass implements CommonInterface {
    @Override
    public void doSomething(String command) {
        System.out.println("被代理类被调用！");
        System.out.println(command);
        System.out.println("被代理类调用结束！");
    }
}