/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.zk;

import java.io.IOException;

import org.apache.zookeeper.ZooKeeper;

import lombok.extern.slf4j.Slf4j;

/**
 * 会话恢复
 *
 * @author zyy43688
 * @version $Id: ConnectionRetrieve.java, v 0.1 2018年5月27日 上午10:47:55 zyy43688 Exp $
 */
@Slf4j
public class ConnectionRetrieve {

    /**
     * 服务端地址
     */
    private static final String  zkServerPath = "127.0.0.1:2181";

    /**
     * 链接超时
     */
    private static final Integer TIMEOUT      = 5000;

    /**
     * 
     * @param args
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        ZooKeeper zooKeeper = new ZooKeeper(zkServerPath, TIMEOUT, null);

        log.info("等待会话连接成功");
        while (zooKeeper.getState() == ZooKeeper.States.CONNECTING) {

        }
        log.info("会话连接成功");

        long sessionId = zooKeeper.getSessionId();
        byte[] password = zooKeeper.getSessionPasswd();
        long timeout = zooKeeper.getSessionTimeout();

        log.info("sessionId={}, password={}, timeout={}", sessionId, password, timeout);

        log.info("等待超时时间：{}", timeout);
        Thread.sleep(timeout);
        log.info("超时等待结束，重新输出会话属性");

        log.info("sessionId={}, password={}, timeout={}", zooKeeper.getSessionId(), zooKeeper.getSessionPasswd(), zooKeeper.getSessionTimeout());

        zooKeeper = new ZooKeeper(zkServerPath, TIMEOUT, null, sessionId, password, false);

        log.info("重新建立连接并等待链接成功");
        while (zooKeeper.getState() == ZooKeeper.States.CONNECTING) {

        }

        log.info("链接已经重建，输出链接信息");
        log.info("sessionId={}, password={}, timeout={}", zooKeeper.getSessionId(), zooKeeper.getSessionPasswd(), zooKeeper.getSessionTimeout());

    }
}