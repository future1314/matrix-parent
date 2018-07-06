/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.rmi;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author zyy43688
 * @version $Id: Hello.java, v 0.1 2018年6月6日 上午10:29:29 zyy43688 Exp $
 */
public interface Hello extends Remote, Serializable {
    String sayHello(String name) throws RemoteException;
}
