package com.zook.api;


public class ZKNode {
	/** app名称 */
	private String app;
	/** 节点名称 */
	private String node;

	public ZKNode() {
	}

	public ZKNode(String app) {
		this.app = app;
	}

	public ZKNode(String app, String node) {
		this.app = app;
		this.node = node;
	}

	public String getNode() {
		return node;
	}

	public String getApp() {
		return app;
	}

	public void setNode(String node) {
		this.node = node;
	}

	public void setApp(String app) {
		this.app = app;
	}

	@Override
	public String toString() {
		return "ZKNode [app=" + app + ", node=" + node + "]";
	}
}
