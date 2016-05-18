package com.elasticsearch.update;

import com.elasticsearch.client.ESTools;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.get.MultiGetItemResponse;
import org.elasticsearch.action.get.MultiGetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateRequestBuilder;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;

import java.io.IOException;
import java.util.Date;

/**
 * Created by Administrator on 2016/5/3 0003.
 */
public class UpdateIndex {

    public static XContentBuilder xContentBuilder()throws IOException{
        XContentBuilder builder= XContentFactory.jsonBuilder().startObject()
                .field("user","tomcat")
                .field("date",new Date())
                .field("gender","male")
                .field("message","trying out Elasticsearch")
                .endObject();
        return builder;
    }

    /**
     * 更新index
     * @param indexName
     * @param type
     * @param id
     * @param builder
     * @return
     * @throws IOException
     */
    public static UpdateRequest updateIndex(String indexName,String type,String id)throws IOException{
        IndexRequest indexRequest=new IndexRequest(indexName,type,id).source(XContentFactory.jsonBuilder().startObject()
                .field("user","tomcat")
                .field("date",new Date()).endObject());
        UpdateRequest updateRequest=new UpdateRequest(indexName,type,id).doc(xContentBuilder()).upsert(indexRequest);
        return updateRequest;
    }

    /**
     *批量获取index
     * @param indexName
     * @param type
     * @param id
     * @return
     */
    public static MultiGetResponse getMulti(String indexName,String type,String id){
        MultiGetResponse multiGetResponse=ESTools.client.prepareMultiGet().add(indexName,type,id).get();
        return multiGetResponse;
    }
    public static void main(String[] args) {
        try {
//            UpdateRequest request = updateIndex("twitter", "twitter", "1");
//
//            ESTools.client.update(request).get();
            MultiGetResponse multiGetResponse=getMulti("twitter", "twitter", "1");
            for (MultiGetItemResponse itemResponse:multiGetResponse){
                GetResponse response=itemResponse.getResponse();
                if (response.isExists()){
                    String json=response.getSourceAsString();
                    System.out.println(json);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ESTools.close();
        }
    }
}
