package com.web.test;

import java.lang.reflect.Constructor;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;




public class ESTest {

	static Map<String,Object> map=new HashMap<String,Object>();
	static Settings settings=Settings.settingsBuilder().put(map).put("cluster.name","elasticsearch").build();

	public static TransportClient client;
	
	static{
		try {
			Class<?> clazz=Class.forName(TransportClient.class.getName());
			Constructor<?> constructor=clazz.getDeclaredConstructor(Settings.class);
			constructor.setAccessible(true);
			client=(TransportClient) constructor.newInstance(settings);
			client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static synchronized TransportClient getTransportClient(){
		return client;
	}
}
