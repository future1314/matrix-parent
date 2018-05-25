/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.matrixsb.zk;

import java.io.IOException;
import java.util.Arrays;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zyy43688
 * @version $Id: ZookeeperDemo.java, v 0.1 2018年5月25日 上午9:59:02 zyy43688 Exp $
 */
@Slf4j
public class ZookeeperDemo {
    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        ZooKeeper zooKeeper = new ZooKeeper("116.85.24.185", 50000, watchedEvent -> {
            log.info("链接回调{}", watchedEvent.getPath());
        });
        log.info(String.valueOf(zooKeeper.getState()));

        Thread.sleep(2000);

        log.info(String.valueOf(zooKeeper.getState()));

        log.info("子节点{}", Arrays.toString(zooKeeper.getChildren("/", true).toArray()));

    }
}