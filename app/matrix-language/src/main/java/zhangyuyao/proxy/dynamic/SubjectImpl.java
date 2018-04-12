/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.proxy.dynamic;

/**
 * @author zyy43688
 * @version $Id: SubjectImpl.java, v 0.1 2018年4月12日 下午4:41:46 zyy43688 Exp $
 */
public class SubjectImpl implements Subject {
    @Override
    public void request(String msg) {
        System.out.println("request方法被调用！");
    }

    @Override
    public void response(String msg, String name) {
        System.out.println(String.format("response方法被调用,msg=%s,name=%s", msg, name));
    }
}