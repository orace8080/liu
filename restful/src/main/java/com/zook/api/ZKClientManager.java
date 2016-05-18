package com.zook.api;

import java.rmi.Naming;
import java.rmi.Remote;
import java.util.ArrayList;
import java.util.List;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import com.exception.LookupException;
import com.zook.api.conts.ServiceConsts;



public final class ZKClientManager extends AbstractZKManager {

	public ZKClientManager(ZKNode zkNode) {
		this("127.0.0.1:2181", zkNode);
	}

	@Deprecated
	public ZKClientManager(String hosts, ZKNode zkNode) {
		this(hosts, 5000, zkNode);
	}

	public ZKClientManager(String hosts, String appName) {
		this(hosts, 5000, appName);
	}
	public ZKClientManager(String hosts, int timeout, String appName) {
		this(hosts, 5000, new ZKNode(appName));
	} 

	@Deprecated
	public ZKClientManager(String hosts, int timeout, ZKNode zkNode) {
		ZooKeeper zk = connect(hosts, timeout);
		if (zk == null) {
			throw new RuntimeException("Init zookeeper failed");
		} else {
			watchNode(zk, zkNode);
		}
	}

	/**
	 * 
	 * 
	 * @param zk
	 * @param zkNode
	 */
	private void watchNode(final ZooKeeper zk, final ZKNode zkNode) {

		try {
			updateLocalData(zk, zk.getChildren("/" + zkNode.getApp(),
					new LocalWatcher(zk, zkNode)), zkNode);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
	}
	

	class LocalWatcher implements Watcher {
		ZooKeeper zk = null;
		ZKNode zkNode = null;

		LocalWatcher(ZooKeeper zk, ZKNode zkNode) {
			this.zk = zk;
			this.zkNode = zkNode;
		}

		public void process(WatchedEvent event) {
			if (event.getType() == Event.EventType.NodeChildrenChanged) {
				LOG.info("Node changed, update local data!");
				watchNode(zk, zkNode);
			}
		}
	}

	/**
	 * 更新本地缓存数据
	 * 
	 * @param zk
	 * @param newNode
	 * @param zkNode
	 */
	private void updateLocalData(final ZooKeeper zk, List<String> newNode,
			final ZKNode zkNode) {
		try {

			List<String> transList = new ArrayList<String>();
			List<String> merchantList = new ArrayList<String>();
			List<String> reportList=new ArrayList<String>();
			for (String nodeName : newNode) {
				String path = new StringBuilder()
					.append("/")
					.append(zkNode.getApp())
					.append("/")
					.append(nodeName)
					.toString();
				byte[] data = zk.getData(path, false, null);
				String value = new String(data);

				if (nodeName.startsWith(ServiceConsts.TRANS)) {
					transList.add(value);
				} 
				else if (nodeName.startsWith(ServiceConsts.MERCHANT)) {
					merchantList.add(value);
				} 
//				else if (nodeName.startsWith(ServiceConsts.REPORT)) {
//					reportList.add(value);
//				}
			}

			RmiHolder.put(ServiceConsts.TRANS, transList);
			RmiHolder.put(ServiceConsts.MERCHANT, merchantList);
//			RmiHolder.put(ServiceConsts.REPORT,reportList);

			LOG.info("trans service urlList -> {}", transList);
			LOG.info("merchant service urlList -> {}", merchantList);
//			LOG.info("report service urlList -> {}", reportList);

		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
	}

	public <T extends Remote> T lookup(String type) throws LookupException {
		try {
			return lookupService(RmiHolder.getRmiUrl(type));
		} catch (LookupException e) {
			e.printStackTrace();
			// 重试
			return lookupService(RmiHolder.getRmiUrl(type));
		}
	}

	/**
	 * 获取RMI服务
	 * 
	 * @seelookup(String type)
	 * @return
	 */
	public <T extends Remote> T lookup() throws LookupException {
		return lookup(ServiceConsts.TRANS);
	}

	/**
	 * 在 JNDI 中查找 RMI 远程服务对象
	 * 
	 * @param url
	 * @return
	 * @throws ConnectException 
	 */
	@SuppressWarnings("unchecked")
	private <T> T lookupService(String url) throws LookupException {
		T remote = null;
		try {
			remote = (T) Naming.lookup(url);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Lookup error -> url: {}", url);
			throw new LookupException("远程服务连接失败, lookup url: "+url);
		}
		return remote;
	}
	
}
