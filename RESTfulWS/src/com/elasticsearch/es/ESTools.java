package com.elasticsearch.es;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
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
//		LoggerUtils.getLogger(clazz,true);
		Settings setting=ImmutableSettings.builder().put("cluster.name", "elasticsearch").build();
		client=new TransportClient(setting).addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
//		LoggerUtils.getLogger(clazz,true);
		}catch(UnknownHostException e){
//			LoggerUtils.getLogger(clazz, true);
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
