package com.elasticsearch.index;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


/**
 * Created by Administrator on 2016/5/3 0003.
 */
@Service("esIndex")
public class ESIndex {
    private static  String ids= UUID.randomUUID().toString();
    
    @Autowired
    private static  Client client;
    
    static{
	    	try{
		    	Settings setting=Settings.builder().put("cluster.name", "elasticsearch").build();
				client=TransportClient.builder().settings(setting).build().addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
	    	}catch(UnknownHostException e){
	    		e.printStackTrace();
	    	}
    	}
    /**
     * 创建索引内容
     * @return
     */
    public static XContentBuilder createIndexContent() throws IOException{
//        ESTools.client.admin().indices().prepareCreate("app").execute().actionGet();

//        // 定义索引字段属性
//        XContentBuilder mapping = XContentFactory.jsonBuilder().startObject();
//        mapping = mapping.startObject("article");
//        mapping = mapping.startObject("id")
//                // 创建索引时使用paoding解析
//                .field("indexAnalyzer", "paoding")
//                // 搜索时使用paoding解析
//                .field("searchAnalyzer", "paoding")
//                .field("store", "yes")
//                .endObject();
//        mapping = mapping.startObject("title")
//                // 创建索引时使用paoding解析
//                .field("indexAnalyzer", "paoding")
//                // 搜索时使用paoding解析
//                .field("searchAnalyzer", "paoding")
//                .field("store", "yes")
//                .endObject();
//        mapping = mapping.startObject("createTime")
//                // 创建索引时使用paoding解析
//                .field("indexAnalyzer", "paoding")
//                // 搜索时使用paoding解析
//                .field("searchAnalyzer", "paoding")
//                .field("store", "yes")
//                .endObject();
//        mapping = mapping.endObject();
//        mapping = mapping.endObject();
//        // type的值必须与第一个startObject("...")内的值相同，且必须有一个根目录，如article为根目录，id、title和createTime为子目录
//        PutMappingRequest mappingRequest = Requests.putMappingRequest("app").type("article").source(mapping);
//        ESTools.client.admin().indices().putMapping(mappingRequest).actionGet();


            XContentBuilder builder= XContentFactory.jsonBuilder().startObject()
                    .field("user","tomcat")
                    .field("date",new Date())
                    .field("id",ids)
                    .field("createDate",new Date()).field("acount_number",80)
                    .field("message","trying out Elasticsearch")
                    .endObject();
            return builder;

    }

    /**
     * 获取索引内容
     * @param indexName
     * @param type
     * @param id
     * @return
     */
    public  GetResponse getIndex(String indexName,String type,String id){
        GetResponse response=client.prepareGet(indexName,type,id).get();
        return response;
    }
    /**
     * 创建索引
     * @param xContentBuilder
     */
    public  void createIndex(String index,String type,String id,XContentBuilder xContentBuilder){
        IndexResponse indexResponse= client.prepareIndex(index,type,id).setSource(xContentBuilder).get();
    }

    /**
     * 批量创建index
     * @param index
     * @param type
     * @param id
     * @paramxContentBuilder
     */
    public  void getBulk(String index,String type,String id) throws IOException{
        BulkRequestBuilder builder=client.prepareBulk();
        builder.add(client.prepareIndex(index,type,id)
                .setSource(createIndexContent()));

        builder.add(client.prepareIndex(index,type,id+1)
                .setSource(createIndexContent()));
        BulkResponse bulkResponse = builder.get();
        if (bulkResponse.hasFailures()){
            System.out.println(bulkResponse.buildFailureMessage());
        }
    }
    /**
     * 删除索引
     * @param indexName
     * @param type
     * @param id
     * @return
     */
    public  DeleteResponse deleteIndex(String indexName,String type,String id){
        DeleteResponse response=client.prepareDelete(indexName, type, id).get();
        return response;
    }
    public  void execute() throws Exception {
        try {
//            DeleteResponse del=deleteIndex("app","article","e3fe5a2d-5302-41cb-931c-21a4ce507369");
//            System.out.println("delete:[index:"+del.getIndex()+",type: "+del.getType()+",id:"+del.getId()
//                    +",content: "+del.getVersion()+"]");
//            //创建索引
            for (int i=0;i<100;i++) {
                String id= UUID.randomUUID().toString();
                createIndex("app", "article", id, createIndexContent());
                createIndex("twitter", "twitter", id, createIndexContent());
                GetResponse response = getIndex("app", "article", id);
                System.out.println("index:" + response.getIndex() + ",type: " + response.getType() + ",id:" + response.getId()
                        + ",content: " + response.getSource());

                getBulk("twitter", "twitter",id);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
   
}
