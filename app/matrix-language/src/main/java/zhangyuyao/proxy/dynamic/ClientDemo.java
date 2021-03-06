/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.proxy.dynamic;

import java.lang.reflect.Proxy;

/**
 * 动态代理
 * 
 * @author zyy43688
 * @version $Id: ClientDemo.java, v 0.1 2018年2月26日 上午11:01:44 zyy43688 Exp $
 */
public class ClientDemo {
    public static void main(String[] args) {

        SubjectImpl target = new SubjectImpl();

        Subject subject = (Subject) Proxy.newProxyInstance(ClientDemo.class.getClassLoader(), new Class[] { Subject.class }, new SubjectHandler(target));
        // 这里面执行的对象的方法
        subject.request("zhangyuyao");

        subject.response("你大爷！", "张玉尧！");
    }
}