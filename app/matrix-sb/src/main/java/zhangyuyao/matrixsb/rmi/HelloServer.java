/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zyy43688
 * @version $Id: HelloServer.java, v 0.1 2018年6月6日 上午10:37:11 zyy43688 Exp $
 */
@Slf4j
public class HelloServer {
    public static void main(String[] args) {
        try {
            Hello h = new HelloImpl();

            LocateRegistry.createRegistry(12313);

            Naming.bind("rmi://10.101.50.37:12313/Hello", h);

            log.info("启动HelloServer");
        } catch (Exception e) {
            log.error("", e);
        }

    }
}