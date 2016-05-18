package test;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.search.SearchHit;

import com.elasticsearch.es.ESTools;

public class ESSearch {

	public static void main(String[] args) {
		 SearchResponse searchResponse = ESTools.client.prepareSearch("logstash-ehome-2016.04.21")
				    //加上这个据说可以提高性能，但第一次却不返回结果
				    .setSearchType(SearchType.SCAN)
				    //实际返回的数量为5*index的主分片格式
				        .setSize(5)
				        //这个游标维持多长时间
				        .setScroll(TimeValue.timeValueMinutes(8))
				        .execute().actionGet();
				    //第一次查询，只返回数量和一个scrollId
				    System.out.println(searchResponse.getHits().getTotalHits());
				    System.out.println(searchResponse.getHits().hits().length);
				    //第一次运行没有结果
				    for (SearchHit hit : searchResponse.getHits()) {
				        System.out.println(hit.getSourceAsString());
				    }
				    System.out.println("------------------------------");
				    //使用上次的scrollId继续访问
				    searchResponse = ESTools.client.prepareSearchScroll(searchResponse.getScrollId())
				        .setScroll(TimeValue.timeValueMinutes(8))
				        .execute().actionGet();
				    System.out.println(searchResponse.getHits().getTotalHits());
				    System.out.println(searchResponse.getHits().hits().length);
				    
				    for (SearchHit hit : searchResponse.getHits()) {
				        System.out.println(hit.getSourceAsString());
				    }
	}
}
