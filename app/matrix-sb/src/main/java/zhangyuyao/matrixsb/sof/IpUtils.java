/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.sof;

import java.net.InetAddress;
import java.net.UnknownHostException;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zyy43688
 * @version $Id: IpUtils.java, v 0.1 2018年5月22日 下午3:47:20 zyy43688 Exp $
 */
@Slf4j
public class IpUtils {

    public static String getLocalHostIp() {
        InetAddress inetAddress = getInetAddress();

        if (inetAddress == null) {
            return null;
        }

        String ip = inetAddress.getHostAddress();

        return ip;
    }

    public static InetAddress getInetAddress() {
        try {
            return InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            log.error("", e);
        }
        return null;
    }

    public static String getLocalHostName() {
        InetAddress inetAddress = getInetAddress();

        if (inetAddress == null) {
            return null;
        }

        String name = inetAddress.getHostName();

        return name;
    }
}