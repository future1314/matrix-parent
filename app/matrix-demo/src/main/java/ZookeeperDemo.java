import static org.apache.zookeeper.ZooKeeper.States.CONNECTING;

import java.io.IOException;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

public class ZookeeperDemo {
    public static void main(String[] args) throws IOException {
        ZooKeeper zooKeeper = new ZooKeeper("116.85.24.185", 10, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                //log.info("链接回调{}", watchedEvent.getPath());
                System.out.println("zzzzzzzzzzzzz");
            }
        }, 0, null);

        while (zooKeeper.getState() == CONNECTING) {

        }

    }
}