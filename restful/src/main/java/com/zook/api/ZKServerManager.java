package com.zook.api;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.util.Random;


import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import com.zook.api.conts.ServiceConsts;
import com.zook.service.DemoService;
import com.zook.service.ITransService;



public final class ZKServerManager extends AbstractZKManager {
	
	private ZooKeeper zk = null;
	private ZKService zkService;

	private String hosts;

	private static int timeout = 5000;

	public ZKServerManager() {
	}

	public ZKServerManager(String hosts) {
		this(hosts, timeout);
	}

	public ZKServerManager(String hosts, int timeout) {
		this.hosts = hosts;
		ZKServerManager.timeout = timeout;
	}

	/**
	 * 发布服务
	 * 
	 * @see #createNode
	 * @see #registryService
	 * 
	 * 
	 * @param zkService
	 *            发布服务所需要的3要素, 分别是提供服务的具体实现类, 提供服务的ip以及端口
	 * @paramzkNode
	 *            需要发布至zookeeper的目标节点
	 * 
	 * @return 发布状态, true成功, false失败
	 */
	public boolean publish(final ZKService zkService) {

		if (zkService == null) {
			throw new RuntimeException("zkService can't be null");
		}
		// if (zkNode == null) {
		// throw new RuntimeException("zkNode can't be null");
		// }

		zk = connect(hosts, timeout);
		if (zk == null) {
			throw new RuntimeException("Connect zookeeper server failed");
		}

		try {
			ZKNode node = null;
			for (Remote remote : zkService.getRemotes()) {
				String url = registryService(remote, zkService.getIp());
				
				if (remote instanceof ITransService) {
					node = new ZKNode(zkService.getApp(), ServiceConsts.TRANS);
				} else {
					throw new RuntimeException("恁在弄啥类...");
				}
				createNode(node, url);
			}
		} catch (Exception e) {
			LOG.error("服务注册失败", e);
			return false;
		}
		return true;
	}

	public boolean publish() {
		return publish(zkService);
	}
	
	/**
	 * 创建服务节点
	 * 
	 * @param node
	 * @param url
	 */
	private void createNode(ZKNode node, String url) {
		String path = new StringBuilder()
				.append("/")
				.append(node.getApp())
				.append("/")
				.append(node.getNode())
					.toString();
		try {
			path = zk.create(
					path, 
					url.getBytes(), 
					ZooDefs.Ids.OPEN_ACL_UNSAFE,
					CreateMode.EPHEMERAL_SEQUENTIAL);
			LOG.info("Create zookeeper success. node path:[{}], url: [{}]",
					path, url);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			throw new RuntimeException("Create node error -> node: " + path);
		}
	}


	/**
	 * 注册rmi服务
	 * 
	 * @paramservice
	 * @return
	 */
	private String registryService(Remote remote, String ip) {
		String url = null;
		try {
			/* 随机使用20100~20199之间的端口 */
			int randomPort = new Random().nextInt(100) + 20100;
			//int randomPort =12325;
			url = String.format("rmi://%s:%d/%s", 
					ip,
					randomPort, 
					remote.getClass().getName()
					/*"com.sand.server.service.TransServiceImpl"*/);
			LOG.info("publish rmi service url: [{}]", url);
			LocateRegistry.createRegistry(randomPort);
			Naming.rebind(url, remote);
			randomPort++;
		} catch (Exception e) {
			LOG.error("发布rmi服务失败", e);
			throw new RuntimeException("发布rmi服务失败");
		}
		return url;
	}

	public ZKService getZkService() {
		return zkService;
	}
	public void setZkService(ZKService zkService) {
		this.zkService = zkService;
	}
	public String getHosts() {
		return hosts;
	}
	public void setHosts(String hosts) {
		this.hosts = hosts;
	}

	public static int getTimeout() {
		return timeout;
	}
	public static void setTimeout(int timeout) {
		ZKServerManager.timeout = timeout;
	}
}
