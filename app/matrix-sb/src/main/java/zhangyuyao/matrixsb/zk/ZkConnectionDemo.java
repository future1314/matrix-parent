/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.zk;

import java.io.IOException;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import lombok.extern.slf4j.Slf4j;

/**
 * Zookeeper链接Demo
 *
 * @author zyy43688
 * @version $Id: ZkConnectionDemo.java, v 0.1 2018年5月27日 上午10:22:08 zyy43688 Exp $
 */
@Slf4j
public class ZkConnectionDemo implements Watcher {

    /**
     * 服务端地址
     */
    public static final String      zkServerPath = "127.0.0.1:2181";

    //    public static final String zkServerPath = ",,,,";

    private volatile static boolean flag         = true;

    /**
     * 会话连接的超时时间还是会话建立的超时时间
     */
    public static final Integer     timeout      = 5000;

    public static void main(String[] args) throws IOException, InterruptedException {
        ZooKeeper zk = new ZooKeeper(zkServerPath, timeout, new ZkConnectionDemo());

        log.info("客户端开始链接zookeeper服务器...");
        log.info("连接状态：{}", zk.getState());

        while (zk.getState() == ZooKeeper.States.CONNECTING) {
            log.info("waiting");
        }

        //        Thread.sleep(2000);

        while (flag) {
            log.info("等待回调");
        }

        log.info("连接状态：{}", zk.getState());

    }

    @Override
    public void process(WatchedEvent event) {
        // 回调方法
        log.info("回调事件：{}", event);
        flag = false;
    }
}