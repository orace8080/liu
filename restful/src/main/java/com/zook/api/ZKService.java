package com.zook.api;

import java.rmi.Remote;

public class ZKService {

	public ZKService() {
	}

	public ZKService(Remote[] remotes, String ip) {
		this.remotes = remotes;
		this.ip = ip;
	}

	public ZKService(Remote[] remotes, String ip, int port) {
		this.remotes = remotes;
		this.ip = ip;
		this.port = port;
	}

	private Remote[] remotes;
	private String ip;
	@Deprecated
	private int port;
	private String app;

	public Remote[] getRemotes() {
		return remotes;
	}

	public void setRemotes(Remote[] remotes) {
		this.remotes = remotes;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}
}
