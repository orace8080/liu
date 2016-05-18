package com.elasticsearch.client;

import org.elasticsearch.client.Client;

public class ESServiceManager extends AbstractESManager {
	
	private String name;
	private String host;
	private int port;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
	public Client  build(){
		Client client=null;
		if(host==null){
			return null;
		}else{
			client=connect(name, host, port);
		}
		return client;
		
		
	}
	

}
