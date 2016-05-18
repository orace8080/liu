package com.elasticsearch.test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.TermRangeQuery;
import org.codehaus.jackson.map.jsontype.impl.MinimalClassNameIdResolver;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.FilterBuilder;
import org.elasticsearch.index.query.FilterBuilders;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.SearchPhase;

import com.elasticsearch.es.ESTools;
import com.elasticsearch.pojo.KibanaVo;

import io.searchbox.core.Search;

public class ElasticsearchTest {
	
	
	public List<KibanaVo> search(QueryBuilder queryBuilder,String index,String type){
//		GetResponse getResponse=ESTools.client.prepareGet(index,type,"AVQ74ujMy3AikzEUM0Rg").execute().actionGet();
//		System.out.println("response.getSourceAsString():"+getResponse.getSourceAsString());
		List<KibanaVo> list=new ArrayList<KibanaVo>();
		 SearchResponse searchResponse = ESTools.client.prepareSearch(index).setTypes(type)
			        .setQuery(queryBuilder).setPostFilter(FilterBuilders.rangeFilter("date").from("2016-04-21").to("2016-04-21"))
			        .execute()
			        .actionGet();
			        SearchHits hits = searchResponse.getHits();
			        SearchHit[] hit=hits.getHits();
			        if(hit.length>0){
			        	for(SearchHit search :hit){
			        		String message=(String)search.getSource().get("message");
			        		String date=(String)search.getSource().get("date");
			        		String request=(String)search.getSource().get("request");
			        		list.add(new KibanaVo(message,request,date));
			        	}
			        }
			        
			        return list;
	} 
	public static void main(String[] args) {
		
		long start=System.currentTimeMillis();
		ElasticsearchTest test=new ElasticsearchTest();
		String index="logstash-ehome-2016.04.21";
		String type="apache_access";
		QueryBuilder queryBuilder=QueryBuilders.matchQuery("message", "2016-04-21");
		List<KibanaVo> vo=test.search(queryBuilder, index, type);
		for(KibanaVo v:vo){
			System.out.println("message:"+v.getMessage()+"\t\t request:"+v.getRequest()+" \t\t date:"+v.getDate());
		}
		
		long end=System.currentTimeMillis();
		System.out.println("耗时 "+(end-start)+"毫秒");
	}
}
