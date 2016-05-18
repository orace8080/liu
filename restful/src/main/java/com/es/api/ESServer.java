package com.es.api;

/**
 * Created by Administrator on 2016/4/25 0025.
 */
public class ESServer{

    private String host;
    private int port;

    public ESServer(){ }

    public ESServer(String host,int port){
        this.host=host;
        this.port=port;
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


}
