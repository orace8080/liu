package com.elasticsearch.client;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

public class ESClientFactory {
	
	 private static Client client;
	 private ESClientFactory()
	 {
	    	Settings settings = ImmutableSettings.settingsBuilder()
	    	        .put("cluster.name", "globalhawk-es-cluster").build();
	    	
	        client = new TransportClient(settings)
	        .addTransportAddress(new InetSocketTransportAddress(
	                "10.21.34.34", 9300))
	        .addTransportAddress(new InetSocketTransportAddress(
	        		"10.21.34.35", 9300));
	 }
	 
	 private static ESClientFactory esClient = new ESClientFactory();
	 
	 public static Client getESClient()
	 {
		 return client;
	 }

}
