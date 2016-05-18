package com.elasticsearch.search;

import com.elasticsearch.client.ESTools;
import org.elasticsearch.action.search.MultiSearchResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
//import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.node.Node;
import org.elasticsearch.node.NodeBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;

/**
 * Created by Administrator on 2016/5/3 0003.
 */
public class SearchIndex {

    private static Node node;
    static{
        Settings setting= Settings.builder().put("cluster.name", "elasticsearch").build();
        node= NodeBuilder.nodeBuilder().settings(setting).node();
    }
    public static void searchIndex(String indexName,String type){
        QueryBuilder queryBuilder= QueryBuilders.matchQuery("host","10.255.20.16");
        SearchResponse response= ESTools.client.prepareSearch().setScroll(new TimeValue(6000)).setQuery(queryBuilder).execute().actionGet();
        SearchHits hits=response.getHits();
        for (SearchHit hit:hits){
            System.out.println(hit.getSourceAsString());
        }
        response=ESTools.client.prepareSearchScroll(response.getScrollId()).setScroll(new TimeValue(6000)).execute().actionGet();
        if (response.getHits().getHits().length==0){
            System.out.println(response.getHits().getHits().length);
        }
    }
    public static void multiSearch(){
        SearchRequestBuilder srb1 = node.client()
                .prepareSearch().setQuery(QueryBuilders.queryStringQuery("elasticsearch")).setSize(1);
        SearchRequestBuilder srb2 = node.client()
                .prepareSearch().setQuery(QueryBuilders.matchQuery("user", "tomcat")).setSize(1);

        MultiSearchResponse sr = node.client().prepareMultiSearch()
                .add(srb1)
                .add(srb2)
                .execute().actionGet();


        long nbHits = 0;
        for (MultiSearchResponse.Item item : sr.getResponses()) {
            SearchResponse response = item.getResponse();
            nbHits += response.getHits().getTotalHits();
            System.out.println(nbHits);
        }

    }
    public static void main(String[] args) {
        searchIndex("logstash-syslog-2016.05.05","syslog");
//        multiSearch();
    }
}
