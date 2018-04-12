/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.proxy.still;

/**
 * 静态代理
 *
 * @author zyy43688
 * @version $Id: User.java, v 0.1 2018年4月12日 下午3:43:39 zyy43688 Exp $
 */
public class User {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        CommonInterface proxy = new ProxyClass(new OriginClass());

        proxy.doSomething("静态代理！");
    }
}