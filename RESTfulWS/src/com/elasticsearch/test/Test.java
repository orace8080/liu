package com.elasticsearch.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;

import com.elasticsearch.es.ESTools;

public class Test {

	public static void main(String[] args) {
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("E://123.txt")));
			
			String line=null;
			StringBuffer sb=new StringBuffer();
			while((line=br.readLine())!=null){
				sb.append(line);
				sb.append("\n");
			}
			Map<String,Object> search_params=new HashMap<String,Object>();
			search_params.put("size","5");
			search_params.put("form", "1");
			QueryBuilder queryBuilder=QueryBuilders.templateQuery(sb.toString(),search_params);
			SearchResponse sr;
			SearchRequestBuilder srb;
			srb=ESTools.client.prepareSearch("indexdemo").setTypes("typedemo").setQuery(queryBuilder);
			sr=srb.get();
			for(SearchHit hit:sr.getHits()){
				System.out.println(hit.getSourceAsString());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getBuilder(){
		try {
			XContentBuilder context=XContentFactory.jsonBuilder().startObject().field("name", "感冒灵颗粒").field("id", 1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
