/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.proxy.still;

/**
 * 代理类
 *
 * @author zyy43688
 * @version $Id: ProxyClass.java, v 0.1 2018年4月12日 下午3:36:47 zyy43688 Exp $
 */
public class ProxyClass implements CommonInterface {

    /**
     * 被代理类
     */
    private CommonInterface target;

    public ProxyClass(CommonInterface target) {
        this.target = target;
    }

    /**
     * 代理方法
     *
     * @param command
     */
    @Override
    public void doSomething(String command) {
        System.out.println("代理类被调用！");
        target.doSomething(command);
        System.out.println("代理类调用结束！");
    }
}