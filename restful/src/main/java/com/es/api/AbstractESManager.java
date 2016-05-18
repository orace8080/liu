package com.es.api;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by Administrator on 2016/4/25 0025.
 */
public class AbstractESManager {

    protected  static Logger LOG= LoggerFactory.getLogger(AbstractESManager.class);

    protected Client connect(String name,String host,int port){
        if (host==null){
            throw new RuntimeException("host can't be null");
        }
        Client client=null;
        Settings settings= Settings.builder().put("cluster.name",name).build();
        try {
            client = TransportClient.builder().settings(settings).build().addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host), port));
            if (client!=null){
                LOG.info("conection success");

            }
            else{
                LOG.info("connection reconnection");
            }
        }catch (UnknownHostException e){
            LOG.info("ES connection Exception");
        }
        return client;
    }


}
