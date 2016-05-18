package com.es.api;

import org.elasticsearch.client.Client;

/**
 * Created by Administrator on 2016/4/25 0025.
 */
public class ESServerManager extends AbstractESManager {
    private static Client client=null;
    private String name;
    private ESServer esServer;

    public ESServerManager(){
    }

    public Client pulish(final ESServer esServer){
        client=connect(name,esServer.getHost(),esServer.getPort());
        if (client!=null){
            return client;
        }
        return null;
    }
    public Client pulish(){
        return pulish(esServer);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ESServer getEsServer() {
        return esServer;
    }

    public void setEsServer(ESServer esServer) {
        this.esServer = esServer;
    }
}
