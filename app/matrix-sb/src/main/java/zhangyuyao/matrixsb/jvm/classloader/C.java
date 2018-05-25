/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.jvm.classloader;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zyy43688
 * @version $Id: C.java, v 0.1 2018年5月21日 上午11:45:29 zyy43688 Exp $
 */
@Slf4j
public class C extends Parent implements A, B {

    static {
        System.out.println(A.a);
    }

    public static void main(String[] args) {
        log.info("{}", C.a);
        log.info("{}", C.b);
    }
}