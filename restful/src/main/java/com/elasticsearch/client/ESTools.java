package com.elasticsearch.client;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
//import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

public class ESTools {

	
	public static final Client client=build();
	
	public static Class clazz=ESTools.class;
	
	private static Client build(){
		if(client!=null){
			return client;
		}
		Client client=null;
		try{
		Settings setting=Settings.builder().put("cluster.name", "elasticsearch").build();
		client=TransportClient.builder().settings(setting).build().addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
		}catch(UnknownHostException e){
			e.printStackTrace();
		}
		return client;
	}

	public static void  close (){
			if(client!=null){
				client.close();
			}
	}
	
}
