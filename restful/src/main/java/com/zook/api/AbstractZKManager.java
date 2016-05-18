package com.zook.api;

import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractZKManager {

	protected Logger LOG = LoggerFactory.getLogger(AbstractZKManager.class);

	private CountDownLatch latch = null;
	
	/**
	 * 连接zk服务器
	 * 
	 * @param hosts 主机地址 e.g.: 127.0.0.1:2181
	 * @param timeout
	 * @return
	 */
	protected ZooKeeper connect(final String hosts, final int timeout) {
		latch = new CountDownLatch(1);
		if (hosts == null) {
			throw new RuntimeException("hosts can't be null");
		}
		ZooKeeper zk = null;
		try {
			zk = new ZooKeeper(hosts, timeout, new Watcher() {
				public void process(WatchedEvent event) {
					if (event.getState() == Event.KeeperState.SyncConnected) {
						latch.countDown();
						LOG.info("Connect success");
					} else if (event.getState() == Event.KeeperState.Disconnected) {
						LOG.error("Connect disconnect, reconnect");
						connect(hosts, timeout);
					}
				}
			});
			latch.await();
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			throw new RuntimeException("Connect fail");
		}
		return zk;
	}
}
